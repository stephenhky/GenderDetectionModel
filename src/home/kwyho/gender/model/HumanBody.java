package home.kwyho.gender.model;

import java.util.List;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;

public class HumanBody {
	public static Attribute genderA;
	public static Attribute heightA;
	public static Attribute weightA;
	public static Attribute breastSizeA;
	public static Attribute neckSizeA;
	public static Attribute legLengthA;
	public static Attribute handLengthA;
	public static Attribute penisLengthA;
	public static Attribute bmiA;
	public static ArrayList<Attribute> attributes;
	public static Integer grape;
	
	static {
		List<String> genderList = new ArrayList<String>();
		genderList.add("M");
		genderList.add("F");
		genderA = new Attribute("gender", genderList);
		heightA = new Attribute("height");
		weightA = new Attribute("weight");
		breastSizeA = new Attribute("breastSize");
		neckSizeA = new Attribute("neckSize");
		legLengthA = new Attribute("legLength");
		handLengthA = new Attribute("handLength");
		penisLengthA = new Attribute("penisLength");
		bmiA = new Attribute("bmi");
		
		attributes = new ArrayList<Attribute>();
		attributes.add(genderA);
		attributes.add(heightA);
		attributes.add(weightA);
		attributes.add(breastSizeA);
		attributes.add(neckSizeA);
		attributes.add(legLengthA);
		attributes.add(handLengthA);
		attributes.add(penisLengthA);
		attributes.add(bmiA);
	}
	
	private Integer gender;
	private Double height;
	private Double weight;
	private Double breastSize;
	private Double neckSize;
	private Double legLength;
	private Double handLength;
	private Double penisLength;
	private Double bmi;
	
	public HumanBody() {
		
	}
	
	public void setBMI() {
		bmi = weight / height / height;
	}

	public HumanBody(int gender, double height, double weight,
			double breastSize, double neckSize, double legLength,
			double handLength, double penisLength) {
		super();
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.breastSize = breastSize;
		this.neckSize = neckSize;
		this.legLength = legLength;
		this.handLength = handLength;
		this.penisLength = penisLength;
		setBMI();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Double getBreastSize() {
		return breastSize;
	}

	public void setBreastSize(double breastSize) {
		this.breastSize = breastSize;
	}

	public Double getNeckSize() {
		return neckSize;
	}

	public void setNeckSize(double neckSize) {
		this.neckSize = neckSize;
	}

	public Double getLegLength() {
		return legLength;
	}

	public void setLegLength(double legLength) {
		this.legLength = legLength;
	}

	public Double getHandLength() {
		return handLength;
	}

	public void setHandLength(double handLength) {
		this.handLength = handLength;
	}

	public Double getPenisLength() {
		return penisLength;
	}

	public void setPenisLength(double penisLength) {
		this.penisLength = penisLength;
	}

	public Double getBmi() {
		return bmi;
	}
	
	public Instance getInstance() {
		Instance inst = new DenseInstance(9);
		
		inst.setValue(genderA, (getGender()==1)?"M":"F");
		inst.setValue(heightA, getHeight());
		inst.setValue(weightA, getWeight());
		inst.setValue(breastSizeA, getBreastSize());
		inst.setValue(neckSizeA, getNeckSize());
		inst.setValue(neckSizeA, getNeckSize());
		inst.setValue(legLengthA, getLegLength());
		inst.setValue(handLengthA, getHandLength());
		inst.setValue(penisLengthA, getPenisLength());
		inst.setValue(bmiA, getBmi());
		
		return inst;
	}

	public static ArrayList<Attribute> getAttributes() {
		return attributes;
	}
}
