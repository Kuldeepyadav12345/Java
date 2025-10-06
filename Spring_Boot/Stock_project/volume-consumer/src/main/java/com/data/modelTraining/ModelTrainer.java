package com.data.modelTraining;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.deeplearning4j.datasets.iterator.utilty.ListDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class ModelTrainer {

    private static final String MODEL_FILE_PATH = "F:\\Git_Hub_Repositories\\Projects\\Java\\Spring_Boot\\Stock_project\\volume-consumer\\src\\main\\resources\\dl4jModel.zip";
    private static final int INPUT_SIZE = 10;
    private static final int OUTPUT_SIZE = 1;

    public static void initializeModelAndSave() {
        System.out.println("Starting model training and saving process...");
        try {
            // Step 1: Create a DataSetIterator with dummy data
            DataSetIterator dataSetIterator = createDummyData();

            // Step 2: Configure the Neural Network
            MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                    .seed(123)
                    .updater(new Adam(0.01))
                    .list()
                    .layer(0, new DenseLayer.Builder()
                            .nIn(INPUT_SIZE)
                            .nOut(50)
                            .activation(Activation.RELU)
                            .weightInit(WeightInit.XAVIER)
                            .build())
                    .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.MSE)
                            .nIn(50)
                            .nOut(OUTPUT_SIZE)
                            .activation(Activation.IDENTITY)
                            .weightInit(WeightInit.XAVIER)
                            .build())
                    .build();

            // Step 3: Build, Train, and Initialize the Network
            MultiLayerNetwork model = new MultiLayerNetwork(conf);
            model.init();
            model.setListeners(new ScoreIterationListener(10));

            // Train the model for a few epochs
            int nEpochs = 5;
            for (int i = 0; i < nEpochs; i++) {
                System.out.println("Training epoch " + (i + 1));
                model.fit(dataSetIterator);
                // Reset the iterator to train on the data again
                dataSetIterator.reset();
            }
            System.out.println("Model training complete.");

            // Step 4: Save the trained model to a file
            File modelFile = new File(MODEL_FILE_PATH);
            ModelSerializer.writeModel(model, modelFile, true);
            System.out.println("Model saved successfully to: " + modelFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An I/O error occurred during model training or saving.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected error occurred.");
        }
    }


    private static DataSetIterator createDummyData() {
        int batchSize = 10;
        int numSamples = 100;
        Random random = new Random(123);
        List<DataSet> dataSets = new ArrayList<>();

        for (int i = 0; i < numSamples; i++) {
            // Features: A random vector of size INPUT_SIZE
            double[] featuresArray = new double[INPUT_SIZE];
            for (int j = 0; j < INPUT_SIZE; j++) {
                featuresArray[j] = random.nextDouble();
            }
            
            // Create a 2D INDArray with shape [1, INPUT_SIZE] for a single sample.
            INDArray features = Nd4j.create(new int[]{1, INPUT_SIZE}, featuresArray);

            // Corrected Line: Create labels with the required 2D shape [1, OUTPUT_SIZE]
            INDArray labels = Nd4j.create(new double[]{random.nextDouble()}, new int[]{1, OUTPUT_SIZE});
            
            dataSets.add(new DataSet(features, labels));
        }

        return new ListDataSetIterator<>(dataSets, batchSize);
    }
}