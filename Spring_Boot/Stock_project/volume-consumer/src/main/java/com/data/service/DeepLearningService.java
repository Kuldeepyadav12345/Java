//package com.data.service;
//
//import org.nd4j.autodiff.listeners.Loss;
//import org.nd4j.linalg.activations.Activation;github.dockerjava.api.model.Device;
//import com.oracle.js.parser.ir.Block;
//
//Activation;
//import org.nd4j.linevice;
//import com.oracle.js.parser.ir.Block;
//
//import ai.djl.ndarray.NDManager;
//import ai.djl.ndarray.NDArray;
//import ai.djl.nn.SequentialBlock;
//import ai.djl.nn.core.Linear;
//import ai.djl.Model;
//import ai.djl.training.DefaultTrainingConfig;
//import ai.djl.training.Trainer;
//import ai.djl.training.loss.Loss;
//import ai.djl.Device;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Service;
//import jakarta.annotation.PostConstruct;
//
//@Service
//@Lazy
//public class DeepLearningService {
//    private static final Logger logger = LoggerFactory.getLogger(DeepLearningService.class);
//    private Model model;
//    private NDManager manager;
//    private boolean isInitialized = false;
//
//    @PostConstruct
//    public void init() {
//        try {
//            manager = NDManager.newBaseManager();
//            initializeModel();
//            isInitialized = true;
//            logger.info("DJL model initialized successfully");
//        } catch (Exception e) {
//            logger.error("Could not initialize model", e);
//            isInitialized = false;
//        }
//    }
//
//    private void initializeModel() {
//        try {
//            model = Model.newInstance("price_predictor");
//            Block block = new SequentialBlock()
//                .add(Linear.builder().setUnits(64).build())
//                .add(Activation::relu)
//                .add(Linear.builder().setUnits(32).build())
//                .add(Activation::relu)
//                .add(Linear.builder().setUnits(16).build())
//                .add(Activation::relu)
//                .add(Linear.builder().setUnits(1).build());
//            
//            model.setBlock(block);
//            
//            DefaultTrainingConfig config = new DefaultTrainingConfig(Loss.l2Loss())
//                .optDevices(new Device[] { Device.cpu() });
//            
//            try (Trainer trainer = model.newTrainer(config)) {
//                trainer.initialize(new ai.djl.ndarray.types.Shape(1, 7)); // 7 input features
//                logger.info("Neural network initialized with improved architecture");
//            }
//        } catch (Exception e) {
//            logger.error("Failed to initialize model", e);
//            throw new RuntimeException("Failed to initialize neural network", e);
//        }
//    }
//
//    public double predict(OptionData data) {
//        if (!isInitialized || model == null || data.getLtp() == null) {
//            return 0.0;
//        }
//        try {
//            // Create input features with normalization
//            float[] features = new float[] {
//                normalizePrice(data.getLtp()),
//                normalizePrice(data.getOpen()),
//                normalizePrice(data.getHigh()),
//                normalizePrice(data.getLow()),
//                normalizeChange(data.getDayChangePerc()),
//                normalizeVolume(data.getVolume()),
//                normalizeOI(data.getOpenInterest())
//            };
//
//            NDArray input = manager.create(features).reshape(1, 7);
//
//            ai.djl.translate.Translator<NDArray, NDArray> translator = new ai.djl.translate.Translator<NDArray, NDArray>() {
//                @Override
//                public ai.djl.ndarray.NDList processInput(ai.djl.translate.TranslatorContext ctx, NDArray input) {
//                    return new ai.djl.ndarray.NDList(input);
//                }
//
//                @Override
//                public NDArray processOutput(ai.djl.translate.TranslatorContext ctx, ai.djl.ndarray.NDList list) {
//                    return list.singletonOrThrow();
//                }
//            };
//
//            try (ai.djl.inference.Predictor<NDArray, NDArray> predictor = model.newPredictor(translator)) {
//                NDArray result = predictor.predict(input);
//                return denormalizePrice(result.getFloat());
//            }
//        } catch (Exception e) {
//            logger.error("Prediction error", e);
//            return data.getLtp(); // Return current LTP if prediction fails
//        }
//    }
//
//    // Normalization helpers
//    private float normalizePrice(double price) {
//        return (float) (price / 10000.0); // Assuming max price is 10000
//    }
//
//    private float normalizeChange(double change) {
//        return (float) (change / 100.0); // Percentage change
//    }
//
//    private float normalizeVolume(long volume) {
//        return (float) (volume / 1000000.0); // Assuming max volume is 1M
//    }
//
//    private float normalizeOI(double oi) {
//        return (float) (oi / 100000.0); // Assuming max OI is 100K
//    }
//
//    private double denormalizePrice(float normalizedPrice) {
//        return normalizedPrice * 10000.0;
//    }
//}
