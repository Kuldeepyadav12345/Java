package com.data.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.springframework.stereotype.Service;

import com.data.model.BankNiftyCompaniesData;



public class Deeplearning4jService {

    private static final int INPUT_FEATURES = 325;
    private static final int OUTPUT_FEATURES = 1;
    private static final String MODEL_FILE = "F:\\Git_Hub_Repositories\\Projects\\Java\\Spring_Boot\\Stock_project\\volume-consumer\\src\\main\\resources\\dl4jModel.zip";

    
   
    
    private static MultiLayerNetwork model;
    private List<DataSet> liveData;

    public Deeplearning4jService() {
        this.liveData = new ArrayList<>();
        loadModel();
    }

    /**
     * Build a new neural network model if no saved model exists.
     */
    private void buildModel() {
        MultiLayerConfiguration config = new NeuralNetConfiguration.Builder()
                .seed(12345)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .updater(new Adam.Builder().learningRate(0.001).build())
                .list()
                .layer(0, new DenseLayer.Builder().nIn(INPUT_FEATURES).nOut(256).activation(Activation.RELU).build())
                .layer(0, new DenseLayer.Builder().nOut(128).activation(Activation.RELU).build())
                .layer(0, new OutputLayer.Builder(LossFunctions.LossFunction.MSE).nOut(1).activation(Activation.IDENTITY).build())

                .build();

        model = new MultiLayerNetwork(config);
        model.init();
        model.setListeners(new ScoreIterationListener(10));
    }

    public double predict(BankNiftyCompaniesData bankNiftyCompaniesData) {
        double[] inputFeatures = extractFeatures(bankNiftyCompaniesData);
        INDArray input = Nd4j.create(inputFeatures).reshape(1, INPUT_FEATURES);
        return model.output(input).getDouble(0);
    }

    public static double[] extractFeatures(BankNiftyCompaniesData bankNiftyCompaniesData) {
        double[] features = new double[INPUT_FEATURES];

        // Example: manually extract fields
        features[0] = bankNiftyCompaniesData.getHDFCBANK_close();
        features[1] = bankNiftyCompaniesData.getICICIBANK_close();
        features[2] = bankNiftyCompaniesData.getSBIN_close();
        features[3] = bankNiftyCompaniesData.getKOTAKBANK_close();
        features[4] = bankNiftyCompaniesData.getAXISBANK_close();
        features[5] = bankNiftyCompaniesData.getPNB_close();
        features[6] = bankNiftyCompaniesData.getBANKBARODA_close();
        features[7] = bankNiftyCompaniesData.getCANBK_close();
        features[8] = bankNiftyCompaniesData.getINDUSINDBK_close();
        features[9] = bankNiftyCompaniesData.getIDFCFIRSTB_close();
        features[10] = bankNiftyCompaniesData.getAUBANK_close();
        features[11] = bankNiftyCompaniesData.getFEDERALBNK_close();
        
        

        return features;
    }


    /**
     * Reinforce the model with a live feedback sample.
     */
    public void reinforce(double[] inputFeatures, double actualOutput) {
        INDArray input = Nd4j.create(inputFeatures).reshape(1, INPUT_FEATURES);
        INDArray output = Nd4j.create(new double[]{actualOutput}).reshape(1, OUTPUT_FEATURES);

        DataSet newData = new DataSet(input, output);
        liveData.add(newData);

        // Incremental training with new sample
        model.fit(newData);

        // Save the model after reinforcement
        saveModel();
    }

    /**
     * Save the current model state to disk.
     */
    private void saveModel() {
        try {
            File modelFile = new File(MODEL_FILE);
            // The model instance is an instance variable of the service.
            // We just need to save this instance to the file.
            ModelSerializer.writeModel(this.model, modelFile, true); 
            System.out.println("Model saved successfully to " + MODEL_FILE);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving the model to disk.");
        }
    }
    /**
     * Load the model from disk, or build a new one if none exists.
     */
    private void loadModel() {
        File file = new File(MODEL_FILE);
        if (file.exists()) {
            try {
            	System.out.println("Loading existing model from " + MODEL_FILE);
                model = ModelSerializer.restoreMultiLayerNetwork(file);
            } catch (IOException e) {
                e.printStackTrace();
                buildModel();
            }
        } else {
            buildModel();
        }
    }

   
}
