package com.data.service;

import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.data.model.OptionData;

import jakarta.annotation.PostConstruct;

@Service
@Lazy
public class Deeplearning4jService {
    private static final Logger logger = LoggerFactory.getLogger(Deeplearning4jService.class);
    private MultiLayerNetwork model;
    private boolean isInitialized = false;

    public Deeplearning4jService() {
    }

    @PostConstruct
    public void init() {
        try {
            initializeModel();
            isInitialized = true;
            logger.info("DL4J model initialization complete");
        } catch (Throwable e) {
            logger.error("Model initialization failed, service will return current LTP values", e);
            isInitialized = false;
        }
    }

    private void initializeModel() {
        try {
            int numInputs = 7;
            MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(123)
                .list()
                .layer(0, new OutputLayer.Builder(org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction.MSE)
                    .nIn(numInputs)
                    .nOut(1)
                    .build())
                .build();

            model = new MultiLayerNetwork(conf);
            model.init();
            logger.info("Neural network initialized");
        } catch (Exception e) {
            logger.error("Model initialization failed", e);
            isInitialized = false;
        }
    }

    public double predict(OptionData data) {
       
        try {
            double[] features = new double[7];
            features[0] = data.getLtp() / 10000.0;
            features[1] = data.getOpen() / 10000.0;
            features[2] = data.getHigh() / 10000.0;
            features[3] = data.getLow() / 10000.0;
            features[4] = data.getDayChangePerc() / 100.0;
            features[5] = data.getVolume() / 1000000.0;
            features[6] = data.getOpenInterest() / 100000.0;

            INDArray input = Nd4j.create(new double[][]{features});
            double prediction = model.output(input).getDouble(0) * 10000.0;
            return prediction;
        } catch (Exception e) {
            logger.error("Prediction failed", e);
            return data.getLtp();
        }
    }
}
