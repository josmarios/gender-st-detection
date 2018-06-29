/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.dl;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.io.ClassPathResource;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;

/**
 *
 * @author josmario
 */
public class ModelGenerator {

    private int seed;
    private double learningRate;
    private int numInputs;
    private int numHiddenNodes;
    private int numOutputs;
    private String trainData;
    private String testData;
    private int batchSize;

    private void readData(String train, String test) {
        try {
            this.trainData = new ClassPathResource("/home/josmario/bias/train.csv").getFile().getPath();
            this.testData = new ClassPathResource("/home/josmario/bias/test.csv").getFile().getPath();

            //Load the training data:
            RecordReader rr = new CSVRecordReader();
//        rr.initialize(new FileSplit(new File("src/main/resources/classification/linear_data_train.csv")));
            rr.initialize(new FileSplit(new File(trainData)));
            DataSetIterator trainIter = new RecordReaderDataSetIterator(rr, batchSize, 0, 2);

            //Load the test/evaluation data:
            RecordReader rrTest = new CSVRecordReader();
            rrTest.initialize(new FileSplit(new File(testData)));
            DataSetIterator testIter = new RecordReaderDataSetIterator(rrTest, batchSize, 0, 2);

        } catch (IOException ex) {
            Logger.getLogger(ModelGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ModelGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generateModel() {

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(seed)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .updater(new Nesterovs(learningRate, 0.9))
                .list()
                .layer(0, new DenseLayer.Builder().nIn(numInputs).nOut(numHiddenNodes)
                        .weightInit(WeightInit.XAVIER)
                        .activation(Activation.RELU)
                        .build())
                .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                        .weightInit(WeightInit.XAVIER)
                        .activation(Activation.SOFTMAX).weightInit(WeightInit.XAVIER)
                        .nIn(numHiddenNodes).nOut(numOutputs).build())
                .pretrain(false).backprop(true).build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        model.setListeners(new ScoreIterationListener(10));  //Print score every 10 parameter updates
        
        
    }

}
