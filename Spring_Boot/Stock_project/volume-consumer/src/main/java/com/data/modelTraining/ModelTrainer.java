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

import com.data.model.BankNiftyCompaniesData;
import com.data.model.OptionData;

public class ModelTrainer {

    private static final String MODEL_FILE_PATH = "F:\\Git_Hub_Repositories\\Projects\\Java\\Spring_Boot\\Stock_project\\volume-consumer\\src\\main\\resources\\dl4jModel.zip";
    private static int INPUT_SIZE = 0; // Number of input features
    private static final int OUTPUT_SIZE = 1;

    public static void initializeModelAndSave(double[] deepLearningInputParam) {
    	INPUT_SIZE=deepLearningInputParam.length;
        System.out.println("Starting model training and saving process...");
        try {
            // Step 1: Create a DataSetIterator with dummy data
            DataSetIterator dataSetIterator = createDummyData(deepLearningInputParam);

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


//    private static DataSetIterator createDummyData(double[] deepLearningInputParam) {
//        int batchSize = 10;
//        int numSamples = 100;
//        Random random = new Random(123);
//        
//        // Create single INDArrays to hold ALL features and labels
//        INDArray allFeatures = Nd4j.create(numSamples, INPUT_SIZE);
//        INDArray allLabels = Nd4j.create(numSamples, OUTPUT_SIZE);
//
//        for (int i = 0; i < numSamples; i++) {
//            // Features: Random vector
//            double[] featuresArray = new double[INPUT_SIZE];
//            for (int j = 0; j < INPUT_SIZE; j++) {
//                featuresArray[j] = random.nextDouble();
//            }
//            
//            // Labels: Single random output
//            double labelValue = 262;
//            
//            // Put the data directly into the pre-allocated arrays at the correct row index 'i'
//            allFeatures.putRow(i, Nd4j.create(featuresArray));
//            allLabels.putRow(i, Nd4j.create(new double[]{labelValue}));
//        }
//        allFeatures.get(Nd4j.create(deepLearningInputParam));
//        
//        // Create a single DataSet object containing all samples
//        DataSet allData = new DataSet(allFeatures, allLabels);
//        
//        // Now, wrap the single DataSet object in a ListDataSetIterator
//        List<DataSet> dataList = allData.asList();
//
//        // The iterator will correctly split the single, large DataSet into batches of size 'batchSize'
//        return new ListDataSetIterator<>(dataList, batchSize);
//    }
    
    
    
    private static DataSetIterator createDummyData(double[] deepLearningInputParam) {
        int batchSize = 10;
        int numSamples = 100;

        // Make sure deepLearningInputParam is size 265
        if (deepLearningInputParam.length <0) {
            throw new IllegalArgumentException("deepLearningInputParam must be of size 265");
        }
        int INPUT_SIZE = deepLearningInputParam.length;   // Set INPUT_SIZE according to param
        int OUTPUT_SIZE = 1;    // Adjust OUTPUT_SIZE as needed

        INDArray allFeatures = Nd4j.create(numSamples, INPUT_SIZE);
        INDArray allLabels = Nd4j.create(numSamples, OUTPUT_SIZE);

        for (int i = 0; i < numSamples; i++) {
            // For each sample, use the same deepLearningInputParam as features (or modify as needed)
            allFeatures.putRow(i, Nd4j.create(deepLearningInputParam));
            double labelValue = 262; // or your rule for label
            allLabels.putRow(i, Nd4j.create(new double[]{labelValue}));
        }

        // Create a single DataSet object containing all samples
        DataSet allData = new DataSet(allFeatures, allLabels);
        List<DataSet> dataList = allData.asList();

        return new ListDataSetIterator<>(dataList, batchSize);
    }

    
public static double[] deepLearningInputParam(OptionData apiData, BankNiftyCompaniesData bankNiftyCompaniesData2, double[] deepLearningInputParam) {
	deepLearningInputParam[0] = bankNiftyCompaniesData2.getHDFCBANK_close();
	deepLearningInputParam[1] = bankNiftyCompaniesData2.getHDFCBANK_dayChange();
	deepLearningInputParam[2] = bankNiftyCompaniesData2.getHDFCBANK_dayChangePerc();
	deepLearningInputParam[3] = bankNiftyCompaniesData2.getHDFCBANK_high();
	deepLearningInputParam[4] = bankNiftyCompaniesData2.getHDFCBANK_highPriceRange();
	deepLearningInputParam[5] = bankNiftyCompaniesData2.getHDFCBANK_lastTradeQty();
	deepLearningInputParam[6] = bankNiftyCompaniesData2.getHDFCBANK_lastTradeTime();
	deepLearningInputParam[7] = bankNiftyCompaniesData2.getHDFCBANK_low();
	deepLearningInputParam[8] = bankNiftyCompaniesData2.getHDFCBANK_lowPriceRange();
	deepLearningInputParam[9] = bankNiftyCompaniesData2.getHDFCBANK_ltp();
	deepLearningInputParam[10] = bankNiftyCompaniesData2.getHDFCBANK_oiDayChange();
	deepLearningInputParam[11] = bankNiftyCompaniesData2.getHDFCBANK_oiDayChangePerc();
	deepLearningInputParam[12] = bankNiftyCompaniesData2.getHDFCBANK_open();
	deepLearningInputParam[13] = bankNiftyCompaniesData2.getHDFCBANK_prevOpenInterest();
	deepLearningInputParam[14] = bankNiftyCompaniesData2.getHDFCBANK_totalBuyQty();
	deepLearningInputParam[15] = bankNiftyCompaniesData2.getHDFCBANK_totalSellQty();
	deepLearningInputParam[16] = bankNiftyCompaniesData2.getHDFCBANK_tsInMillis();
	deepLearningInputParam[17] = bankNiftyCompaniesData2.getHDFCBANK_volume();
	deepLearningInputParam[18] = bankNiftyCompaniesData2.getHDFCBANK_yearHighPrice();
	deepLearningInputParam[19] = bankNiftyCompaniesData2.getHDFCBANK_yearLowPrice();
	
	deepLearningInputParam[20] = bankNiftyCompaniesData2.getICICIBANK_close();
	deepLearningInputParam[21] = bankNiftyCompaniesData2.getICICIBANK_dayChange();
	deepLearningInputParam[22] = bankNiftyCompaniesData2.getICICIBANK_dayChangePerc();
	deepLearningInputParam[23] = bankNiftyCompaniesData2.getICICIBANK_high();
	deepLearningInputParam[24] = bankNiftyCompaniesData2.getICICIBANK_highPriceRange();
	deepLearningInputParam[25] = bankNiftyCompaniesData2.getICICIBANK_lastTradeQty();
	deepLearningInputParam[26] = bankNiftyCompaniesData2.getICICIBANK_lastTradeTime();
	deepLearningInputParam[27] = bankNiftyCompaniesData2.getICICIBANK_low();
	deepLearningInputParam[28] = bankNiftyCompaniesData2.getICICIBANK_lowPriceRange();
	deepLearningInputParam[29] = bankNiftyCompaniesData2.getICICIBANK_ltp();
	deepLearningInputParam[30] = bankNiftyCompaniesData2.getICICIBANK_oiDayChange();
	deepLearningInputParam[31] = bankNiftyCompaniesData2.getICICIBANK_oiDayChangePerc();
	deepLearningInputParam[32] = bankNiftyCompaniesData2.getICICIBANK_open();
	deepLearningInputParam[33] = bankNiftyCompaniesData2.getICICIBANK_prevOpenInterest();
	deepLearningInputParam[34] = bankNiftyCompaniesData2.getICICIBANK_totalBuyQty();
	deepLearningInputParam[35] = bankNiftyCompaniesData2.getICICIBANK_totalSellQty();
	deepLearningInputParam[36] = bankNiftyCompaniesData2.getICICIBANK_tsInMillis();
	deepLearningInputParam[37] = bankNiftyCompaniesData2.getICICIBANK_volume();
	deepLearningInputParam[38] = bankNiftyCompaniesData2.getICICIBANK_yearHighPrice();
	deepLearningInputParam[39] = bankNiftyCompaniesData2.getICICIBANK_yearLowPrice();
	
	deepLearningInputParam[40] = bankNiftyCompaniesData2.getSBIN_close();
	deepLearningInputParam[41] = bankNiftyCompaniesData2.getSBIN_dayChange();
	deepLearningInputParam[42] = bankNiftyCompaniesData2.getSBIN_dayChangePerc();
	deepLearningInputParam[43] = bankNiftyCompaniesData2.getSBIN_high();
	deepLearningInputParam[44] = bankNiftyCompaniesData2.getSBIN_highPriceRange();
	deepLearningInputParam[45] = bankNiftyCompaniesData2.getSBIN_lastTradeQty();
	deepLearningInputParam[46] = bankNiftyCompaniesData2.getSBIN_lastTradeTime();
	deepLearningInputParam[47] = bankNiftyCompaniesData2.getSBIN_low();
	deepLearningInputParam[48] = bankNiftyCompaniesData2.getSBIN_lowPriceRange();
	deepLearningInputParam[49] = bankNiftyCompaniesData2.getSBIN_ltp();
	deepLearningInputParam[50] = bankNiftyCompaniesData2.getSBIN_oiDayChange();
	deepLearningInputParam[51] = bankNiftyCompaniesData2.getSBIN_oiDayChangePerc();
	deepLearningInputParam[52] = bankNiftyCompaniesData2.getSBIN_open();
	deepLearningInputParam[53] = bankNiftyCompaniesData2.getSBIN_prevOpenInterest();
	deepLearningInputParam[54] = bankNiftyCompaniesData2.getSBIN_totalBuyQty();
	deepLearningInputParam[55] = bankNiftyCompaniesData2.getSBIN_totalSellQty();
	deepLearningInputParam[56] = bankNiftyCompaniesData2.getSBIN_tsInMillis();
	deepLearningInputParam[57] = bankNiftyCompaniesData2.getSBIN_volume();
	deepLearningInputParam[58] = bankNiftyCompaniesData2.getSBIN_yearHighPrice();
	deepLearningInputParam[59] = bankNiftyCompaniesData2.getSBIN_yearLowPrice();
	
	deepLearningInputParam[60] = bankNiftyCompaniesData2.getKOTAKBANK_close();
	deepLearningInputParam[61] = bankNiftyCompaniesData2.getKOTAKBANK_dayChange();
	deepLearningInputParam[62] = bankNiftyCompaniesData2.getKOTAKBANK_dayChangePerc();
	deepLearningInputParam[63] = bankNiftyCompaniesData2.getKOTAKBANK_high();
	deepLearningInputParam[64] = bankNiftyCompaniesData2.getKOTAKBANK_highPriceRange();
	deepLearningInputParam[65] = bankNiftyCompaniesData2.getKOTAKBANK_lastTradeQty();
	deepLearningInputParam[66] = bankNiftyCompaniesData2.getKOTAKBANK_lastTradeTime();
	deepLearningInputParam[67] = bankNiftyCompaniesData2.getKOTAKBANK_low();
	deepLearningInputParam[68] = bankNiftyCompaniesData2.getKOTAKBANK_lowPriceRange();
	deepLearningInputParam[69] = bankNiftyCompaniesData2.getKOTAKBANK_ltp();
	deepLearningInputParam[70] = bankNiftyCompaniesData2.getKOTAKBANK_oiDayChange();
	deepLearningInputParam[71] = bankNiftyCompaniesData2.getKOTAKBANK_oiDayChangePerc();
	deepLearningInputParam[72] = bankNiftyCompaniesData2.getKOTAKBANK_open();
	deepLearningInputParam[73] = bankNiftyCompaniesData2.getKOTAKBANK_prevOpenInterest();
	deepLearningInputParam[74] = bankNiftyCompaniesData2.getKOTAKBANK_totalBuyQty();
	deepLearningInputParam[75] = bankNiftyCompaniesData2.getKOTAKBANK_totalSellQty();
	deepLearningInputParam[76] = bankNiftyCompaniesData2.getKOTAKBANK_tsInMillis();
	deepLearningInputParam[77] = bankNiftyCompaniesData2.getKOTAKBANK_volume();
	deepLearningInputParam[78] = bankNiftyCompaniesData2.getKOTAKBANK_yearHighPrice();
	deepLearningInputParam[79] = bankNiftyCompaniesData2.getKOTAKBANK_yearLowPrice();
	
	deepLearningInputParam[80] = bankNiftyCompaniesData2.getAXISBANK_close();
	deepLearningInputParam[81] = bankNiftyCompaniesData2.getAXISBANK_dayChange();
	deepLearningInputParam[82] = bankNiftyCompaniesData2.getAXISBANK_dayChangePerc();
	deepLearningInputParam[83] = bankNiftyCompaniesData2.getAXISBANK_high();
	deepLearningInputParam[84] = bankNiftyCompaniesData2.getAXISBANK_highPriceRange();
	deepLearningInputParam[85] = bankNiftyCompaniesData2.getAXISBANK_lastTradeQty();
	deepLearningInputParam[86] = bankNiftyCompaniesData2.getAXISBANK_lastTradeTime();
	deepLearningInputParam[87] = bankNiftyCompaniesData2.getAXISBANK_low();
	deepLearningInputParam[88] = bankNiftyCompaniesData2.getAXISBANK_lowPriceRange();
	deepLearningInputParam[89] = bankNiftyCompaniesData2.getAXISBANK_ltp();
	deepLearningInputParam[90] = bankNiftyCompaniesData2.getAXISBANK_oiDayChange();
	deepLearningInputParam[91] = bankNiftyCompaniesData2.getAXISBANK_oiDayChangePerc();
	deepLearningInputParam[92] = bankNiftyCompaniesData2.getAXISBANK_open();
	deepLearningInputParam[93] = bankNiftyCompaniesData2.getAXISBANK_prevOpenInterest();
	deepLearningInputParam[94] = bankNiftyCompaniesData2.getAXISBANK_totalBuyQty();
	deepLearningInputParam[95] = bankNiftyCompaniesData2.getAXISBANK_totalSellQty();
	deepLearningInputParam[96] = bankNiftyCompaniesData2.getAXISBANK_tsInMillis();
	deepLearningInputParam[97] = bankNiftyCompaniesData2.getAXISBANK_volume();
	deepLearningInputParam[98] = bankNiftyCompaniesData2.getAXISBANK_yearHighPrice();
	deepLearningInputParam[99] = bankNiftyCompaniesData2.getAXISBANK_yearLowPrice();
	
	deepLearningInputParam[100] = bankNiftyCompaniesData2.getPNB_close();
	deepLearningInputParam[101] = bankNiftyCompaniesData2.getPNB_dayChange();
	deepLearningInputParam[102] = bankNiftyCompaniesData2.getPNB_dayChangePerc();
	deepLearningInputParam[103] = bankNiftyCompaniesData2.getPNB_high();
	deepLearningInputParam[104] = bankNiftyCompaniesData2.getPNB_highPriceRange();
	deepLearningInputParam[105] = bankNiftyCompaniesData2.getPNB_lastTradeQty();
	deepLearningInputParam[106] = bankNiftyCompaniesData2.getPNB_lastTradeTime();
	deepLearningInputParam[107] = bankNiftyCompaniesData2.getPNB_low();
	deepLearningInputParam[108] = bankNiftyCompaniesData2.getPNB_lowPriceRange();
	deepLearningInputParam[109] = bankNiftyCompaniesData2.getPNB_ltp();
	deepLearningInputParam[110] = bankNiftyCompaniesData2.getPNB_oiDayChange();
	deepLearningInputParam[111] = bankNiftyCompaniesData2.getPNB_oiDayChangePerc();
	deepLearningInputParam[112] = bankNiftyCompaniesData2.getPNB_open();
	deepLearningInputParam[113] = bankNiftyCompaniesData2.getPNB_prevOpenInterest();
	deepLearningInputParam[114] = bankNiftyCompaniesData2.getPNB_totalBuyQty();
	deepLearningInputParam[115] = bankNiftyCompaniesData2.getPNB_totalSellQty();
	deepLearningInputParam[116] = bankNiftyCompaniesData2.getPNB_tsInMillis();
	deepLearningInputParam[117] = bankNiftyCompaniesData2.getPNB_volume();
	deepLearningInputParam[118] = bankNiftyCompaniesData2.getPNB_yearHighPrice();
	deepLearningInputParam[119] = bankNiftyCompaniesData2.getPNB_yearLowPrice();
	
	deepLearningInputParam[120] = bankNiftyCompaniesData2.getBANKBARODA_close();
	deepLearningInputParam[121] = bankNiftyCompaniesData2.getBANKBARODA_dayChange();
	deepLearningInputParam[122] = bankNiftyCompaniesData2.getBANKBARODA_dayChangePerc();
	deepLearningInputParam[123] = bankNiftyCompaniesData2.getBANKBARODA_high();
	deepLearningInputParam[124] = bankNiftyCompaniesData2.getBANKBARODA_highPriceRange();
	deepLearningInputParam[125] = bankNiftyCompaniesData2.getBANKBARODA_lastTradeQty();
	deepLearningInputParam[126] = bankNiftyCompaniesData2.getBANKBARODA_lastTradeTime();
	deepLearningInputParam[127] = bankNiftyCompaniesData2.getBANKBARODA_low();
	deepLearningInputParam[128] = bankNiftyCompaniesData2.getBANKBARODA_lowPriceRange();
	deepLearningInputParam[129] = bankNiftyCompaniesData2.getBANKBARODA_ltp();
	deepLearningInputParam[130] = bankNiftyCompaniesData2.getBANKBARODA_oiDayChange();
	deepLearningInputParam[131] = bankNiftyCompaniesData2.getBANKBARODA_oiDayChangePerc();
	deepLearningInputParam[132] = bankNiftyCompaniesData2.getBANKBARODA_open();
	deepLearningInputParam[133] = bankNiftyCompaniesData2.getBANKBARODA_prevOpenInterest();
	deepLearningInputParam[134] = bankNiftyCompaniesData2.getBANKBARODA_totalBuyQty();
	deepLearningInputParam[135] = bankNiftyCompaniesData2.getBANKBARODA_totalSellQty();
	deepLearningInputParam[136] = bankNiftyCompaniesData2.getBANKBARODA_tsInMillis();
	deepLearningInputParam[137] = bankNiftyCompaniesData2.getBANKBARODA_volume();
	deepLearningInputParam[138] = bankNiftyCompaniesData2.getBANKBARODA_yearHighPrice();
	deepLearningInputParam[139] = bankNiftyCompaniesData2.getBANKBARODA_yearLowPrice();
	
	deepLearningInputParam[140] = bankNiftyCompaniesData2.getCANBK_close();
	deepLearningInputParam[141] = bankNiftyCompaniesData2.getCANBK_dayChange();
	deepLearningInputParam[142] = bankNiftyCompaniesData2.getCANBK_dayChangePerc();
	deepLearningInputParam[143] = bankNiftyCompaniesData2.getCANBK_high();
	deepLearningInputParam[144] = bankNiftyCompaniesData2.getCANBK_highPriceRange();
	deepLearningInputParam[145] = bankNiftyCompaniesData2.getCANBK_lastTradeQty();
	deepLearningInputParam[146] = bankNiftyCompaniesData2.getCANBK_lastTradeTime();
	deepLearningInputParam[147] = bankNiftyCompaniesData2.getCANBK_low();
	deepLearningInputParam[148] = bankNiftyCompaniesData2.getCANBK_lowPriceRange();
	deepLearningInputParam[149] = bankNiftyCompaniesData2.getCANBK_ltp();
	deepLearningInputParam[150] = bankNiftyCompaniesData2.getCANBK_oiDayChange();
	deepLearningInputParam[151] = bankNiftyCompaniesData2.getCANBK_oiDayChangePerc();
	deepLearningInputParam[152] = bankNiftyCompaniesData2.getCANBK_open();
	deepLearningInputParam[153] = bankNiftyCompaniesData2.getCANBK_prevOpenInterest();
	deepLearningInputParam[154] = bankNiftyCompaniesData2.getCANBK_totalBuyQty();
	deepLearningInputParam[155] = bankNiftyCompaniesData2.getCANBK_totalSellQty();
	deepLearningInputParam[156] = bankNiftyCompaniesData2.getCANBK_tsInMillis();
	deepLearningInputParam[157] = bankNiftyCompaniesData2.getCANBK_volume();
	deepLearningInputParam[158] = bankNiftyCompaniesData2.getCANBK_yearHighPrice();
	deepLearningInputParam[159] = bankNiftyCompaniesData2.getCANBK_yearLowPrice();
	
	deepLearningInputParam[160] = bankNiftyCompaniesData2.getINDUSINDBK_close();
	deepLearningInputParam[161] = bankNiftyCompaniesData2.getINDUSINDBK_dayChange();
	deepLearningInputParam[162] = bankNiftyCompaniesData2.getINDUSINDBK_dayChangePerc();
	deepLearningInputParam[163] = bankNiftyCompaniesData2.getINDUSINDBK_high();
	deepLearningInputParam[164] = bankNiftyCompaniesData2.getINDUSINDBK_highPriceRange();
	deepLearningInputParam[165] = bankNiftyCompaniesData2.getINDUSINDBK_lastTradeQty();
	deepLearningInputParam[166] = bankNiftyCompaniesData2.getINDUSINDBK_lastTradeTime();
	deepLearningInputParam[167] = bankNiftyCompaniesData2.getINDUSINDBK_low();
	deepLearningInputParam[168] = bankNiftyCompaniesData2.getINDUSINDBK_lowPriceRange();
	deepLearningInputParam[169] = bankNiftyCompaniesData2.getINDUSINDBK_ltp();
	deepLearningInputParam[170] = bankNiftyCompaniesData2.getINDUSINDBK_oiDayChange();
	deepLearningInputParam[171] = bankNiftyCompaniesData2.getINDUSINDBK_oiDayChangePerc();
	deepLearningInputParam[172] = bankNiftyCompaniesData2.getINDUSINDBK_open();
	deepLearningInputParam[173] = bankNiftyCompaniesData2.getINDUSINDBK_prevOpenInterest();
	deepLearningInputParam[174] = bankNiftyCompaniesData2.getINDUSINDBK_totalBuyQty();
	deepLearningInputParam[175] = bankNiftyCompaniesData2.getINDUSINDBK_totalSellQty();
	deepLearningInputParam[176] = bankNiftyCompaniesData2.getINDUSINDBK_tsInMillis();
	deepLearningInputParam[177] = bankNiftyCompaniesData2.getINDUSINDBK_volume();
	deepLearningInputParam[178] = bankNiftyCompaniesData2.getINDUSINDBK_yearHighPrice();
	deepLearningInputParam[179] = bankNiftyCompaniesData2.getINDUSINDBK_yearLowPrice();
	
	deepLearningInputParam[180] = bankNiftyCompaniesData2.getIDFCFIRSTB_close();
	deepLearningInputParam[181] = bankNiftyCompaniesData2.getIDFCFIRSTB_dayChange();
	deepLearningInputParam[182] = bankNiftyCompaniesData2.getIDFCFIRSTB_dayChangePerc();
	deepLearningInputParam[183] = bankNiftyCompaniesData2.getIDFCFIRSTB_high();
	deepLearningInputParam[184] = bankNiftyCompaniesData2.getIDFCFIRSTB_highPriceRange();
	deepLearningInputParam[185] = bankNiftyCompaniesData2.getIDFCFIRSTB_lastTradeQty();
	deepLearningInputParam[186] = bankNiftyCompaniesData2.getIDFCFIRSTB_lastTradeTime();
	deepLearningInputParam[187] = bankNiftyCompaniesData2.getIDFCFIRSTB_low();
	deepLearningInputParam[188] = bankNiftyCompaniesData2.getIDFCFIRSTB_lowPriceRange();
	deepLearningInputParam[189] = bankNiftyCompaniesData2.getIDFCFIRSTB_ltp();
	deepLearningInputParam[190] = bankNiftyCompaniesData2.getIDFCFIRSTB_oiDayChange();
	deepLearningInputParam[191] = bankNiftyCompaniesData2.getIDFCFIRSTB_oiDayChangePerc();
	deepLearningInputParam[192] = bankNiftyCompaniesData2.getIDFCFIRSTB_open();
	deepLearningInputParam[193] = bankNiftyCompaniesData2.getIDFCFIRSTB_prevOpenInterest();
	deepLearningInputParam[194] = bankNiftyCompaniesData2.getIDFCFIRSTB_totalBuyQty();
	deepLearningInputParam[195] = bankNiftyCompaniesData2.getIDFCFIRSTB_totalSellQty();
	deepLearningInputParam[196] = bankNiftyCompaniesData2.getIDFCFIRSTB_tsInMillis();
	deepLearningInputParam[197] = bankNiftyCompaniesData2.getIDFCFIRSTB_volume();
	deepLearningInputParam[198] = bankNiftyCompaniesData2.getIDFCFIRSTB_yearHighPrice();
	deepLearningInputParam[199] = bankNiftyCompaniesData2.getIDFCFIRSTB_yearLowPrice();
	
	deepLearningInputParam[200] = bankNiftyCompaniesData2.getAUBANK_close();
	deepLearningInputParam[201] = bankNiftyCompaniesData2.getAUBANK_dayChange();
	deepLearningInputParam[202] = bankNiftyCompaniesData2.getAUBANK_dayChangePerc();
	deepLearningInputParam[203] = bankNiftyCompaniesData2.getAUBANK_high();
	deepLearningInputParam[204] = bankNiftyCompaniesData2.getAUBANK_highPriceRange();
	deepLearningInputParam[205] = bankNiftyCompaniesData2.getAUBANK_lastTradeQty();
	deepLearningInputParam[206] = bankNiftyCompaniesData2.getAUBANK_lastTradeTime();
	deepLearningInputParam[207] = bankNiftyCompaniesData2.getAUBANK_low();
	deepLearningInputParam[208] = bankNiftyCompaniesData2.getAUBANK_lowPriceRange();
	deepLearningInputParam[209] = bankNiftyCompaniesData2.getAUBANK_ltp();
	deepLearningInputParam[210] = bankNiftyCompaniesData2.getAUBANK_oiDayChange();
	deepLearningInputParam[211] = bankNiftyCompaniesData2.getAUBANK_oiDayChangePerc();
	deepLearningInputParam[212] = bankNiftyCompaniesData2.getAUBANK_open();
	deepLearningInputParam[213] = bankNiftyCompaniesData2.getAUBANK_prevOpenInterest();
	deepLearningInputParam[214] = bankNiftyCompaniesData2.getAUBANK_totalBuyQty();
	deepLearningInputParam[215] = bankNiftyCompaniesData2.getAUBANK_totalSellQty();
	deepLearningInputParam[216] = bankNiftyCompaniesData2.getAUBANK_tsInMillis();
	deepLearningInputParam[217] = bankNiftyCompaniesData2.getAUBANK_volume();
	deepLearningInputParam[218] = bankNiftyCompaniesData2.getAUBANK_yearHighPrice();
	deepLearningInputParam[219] = bankNiftyCompaniesData2.getAUBANK_yearLowPrice();
	
	deepLearningInputParam[220] = bankNiftyCompaniesData2.getFEDERALBNK_close();
	deepLearningInputParam[221] = bankNiftyCompaniesData2.getFEDERALBNK_dayChange();
	deepLearningInputParam[222] = bankNiftyCompaniesData2.getFEDERALBNK_dayChangePerc();
	deepLearningInputParam[223] = bankNiftyCompaniesData2.getFEDERALBNK_high();
	deepLearningInputParam[224] = bankNiftyCompaniesData2.getFEDERALBNK_highPriceRange();
	deepLearningInputParam[225] = bankNiftyCompaniesData2.getFEDERALBNK_lastTradeQty();
	deepLearningInputParam[226] = bankNiftyCompaniesData2.getFEDERALBNK_lastTradeTime();
	deepLearningInputParam[227] = bankNiftyCompaniesData2.getFEDERALBNK_low();
	deepLearningInputParam[228] = bankNiftyCompaniesData2.getFEDERALBNK_lowPriceRange();
	deepLearningInputParam[229] = bankNiftyCompaniesData2.getFEDERALBNK_ltp();
	deepLearningInputParam[230] = bankNiftyCompaniesData2.getFEDERALBNK_oiDayChange();
	deepLearningInputParam[231] = bankNiftyCompaniesData2.getFEDERALBNK_oiDayChangePerc();
	deepLearningInputParam[232] = bankNiftyCompaniesData2.getFEDERALBNK_open();
	deepLearningInputParam[233] = bankNiftyCompaniesData2.getFEDERALBNK_prevOpenInterest();
	deepLearningInputParam[234] = bankNiftyCompaniesData2.getFEDERALBNK_totalBuyQty();
	deepLearningInputParam[235] = bankNiftyCompaniesData2.getFEDERALBNK_totalSellQty();
	deepLearningInputParam[236] = bankNiftyCompaniesData2.getFEDERALBNK_tsInMillis();
	deepLearningInputParam[237] = bankNiftyCompaniesData2.getFEDERALBNK_volume();
	deepLearningInputParam[238] = bankNiftyCompaniesData2.getFEDERALBNK_yearHighPrice();
	deepLearningInputParam[239] = bankNiftyCompaniesData2.getFEDERALBNK_yearLowPrice();
	
	
	deepLearningInputParam[240] = bankNiftyCompaniesData2.getHighestOptChainVol_tsInMillis();
	deepLearningInputParam[241] = bankNiftyCompaniesData2.getHighestOptChainVol_open();
	deepLearningInputParam[242] = bankNiftyCompaniesData2.getHighestOptChainVol_high();
	deepLearningInputParam[243] = bankNiftyCompaniesData2.getHighestOptChainVol_low();
	deepLearningInputParam[244] = bankNiftyCompaniesData2.getHighestOptChainVol_close();
	deepLearningInputParam[245] = bankNiftyCompaniesData2.getHighestOptChainVol_dayChange();
	deepLearningInputParam[246] = bankNiftyCompaniesData2.getHighestOptChainVol_dayChangePerc();
	deepLearningInputParam[247] = bankNiftyCompaniesData2.getHighestOptChainVol_lowPriceRange();
	deepLearningInputParam[248] = bankNiftyCompaniesData2.getHighestOptChainVol_highPriceRange();
	deepLearningInputParam[249] = bankNiftyCompaniesData2.getHighestOptChainVol_volume();
	deepLearningInputParam[250] = bankNiftyCompaniesData2.getHighestOptChainVol_lowTradeRange();
	deepLearningInputParam[251] = bankNiftyCompaniesData2.getHighestOptChainVol_highTradeRange();
	deepLearningInputParam[252] = bankNiftyCompaniesData2.getHighestOptChainVol_totalBuyQty();
	deepLearningInputParam[253] = bankNiftyCompaniesData2.getHighestOptChainVol_totalSellQty();
	deepLearningInputParam[254] = bankNiftyCompaniesData2.getHighestOptChainVol_openInterest();
	deepLearningInputParam[255] = bankNiftyCompaniesData2.getHighestOptChainVol_prevOpenInterest();
	deepLearningInputParam[256] = bankNiftyCompaniesData2.getHighestOptChainVol_oiDayChange();
	deepLearningInputParam[257] = bankNiftyCompaniesData2.getHighestOptChainVol_oiDayChangePerc();
	deepLearningInputParam[258] = bankNiftyCompaniesData2.getHighestOptChainVol_lastTradeQty();
	deepLearningInputParam[259] = bankNiftyCompaniesData2.getHighestOptChainVol_lastTradeTime();
	deepLearningInputParam[260] = bankNiftyCompaniesData2.getHighestOptChainVol_stopLossLtp();
	deepLearningInputParam[261] = bankNiftyCompaniesData2.getHighestOptChainVol_targetLtp();
	deepLearningInputParam[262] = bankNiftyCompaniesData2.getHighestOptChainVol_ltp();
	

		return deepLearningInputParam;
	}
}