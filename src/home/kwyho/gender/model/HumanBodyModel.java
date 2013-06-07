package home.kwyho.gender.model;

import java.util.Random;

public class HumanBodyModel {
	public static double GoldenRatio = 1.6180339887496482;
	private Random random;
	private double BMIMean = 21.0;
	private double BMISigma = 5.0;
	private double heightMaleMean = 180.0;
	private double heightMaleSigma = 5.0;
	private double heightFemaleMean = 150.0;
	private double heightFemaleSigma = 5.0;
	private double bodyWidthRatioSigma = 0.1;
	private double neckRatioMean = 0.15;
	private double neckRatioSigma = 0.001;
	private double penisDecay = 0.0001;
	
	public HumanBodyModel() {
		random = new Random();
	}
	
	private double getRandomBMI() {
		return random.nextGaussian()*BMISigma+BMIMean;
	}
	
	private double getRandomHeight(int gender) {
		return random.nextGaussian()*((gender>0)?heightMaleSigma:heightFemaleSigma)+((gender>0)?heightMaleMean:heightFemaleMean);
	}
	
	private double getWeight(double bmi, double height) {
		return bmi*height*height;
	}
	
	private double getRandomBreastSize(double height, int gender) {
		double bodyWidth = height * (random.nextGaussian()*bodyWidthRatioSigma+HumanBodyModel.GoldenRatio) * 2;
		double breastRatio = random.nextGaussian()*((gender>0)?0.1:0.3)+((gender>0)?1.0:1.8);
		return bodyWidth * breastRatio;
	}
	
	private double getRandomNeckSize(double height) {
		return height * (random.nextGaussian()*neckRatioSigma+neckRatioMean);
	}
	
	private double getRandomLegLength(double height) {
		return height * (random.nextGaussian()*HumanBodyModel.GoldenRatio+0.1);
	}
	
	private double getRandomHandLength(double height) {
		return height * (random.nextGaussian()*HumanBodyModel.GoldenRatio+0.1);
	}
	
	private double getRandomPenisLength(int gender) {
		if (gender < 0) {
			return random.nextGaussian()*0.0001-0.1;
		} else {
			double a = random.nextDouble();
			return -1.0/penisDecay*Math.log(1-a);
		}
	}
	
	public HumanBody getRandomHuman() {
		int gender = (random.nextDouble()>0.5?1:-1);
		double bmi = getRandomBMI();
		double height = getRandomHeight(gender);
		double weight = getWeight(bmi, height);
		double breastSize = getRandomBreastSize(height, gender);
		double neckSize = getRandomNeckSize(height);
		double legLength = getRandomLegLength(height);
		double handLength = getRandomHandLength(height);
		double penisLength = getRandomPenisLength(gender);
		
		HumanBody human = new HumanBody(gender, height, weight, breastSize, neckSize, legLength, handLength, penisLength);
		
		return human;
	}
}
