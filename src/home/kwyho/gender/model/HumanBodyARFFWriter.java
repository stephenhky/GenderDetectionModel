package home.kwyho.gender.model;

import java.io.File;
import java.io.IOException;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

public class HumanBodyARFFWriter {
	public static int DEFAULT_NUMSAMPLES = 100000;
	
	public static String getHelp() {
		StringBuffer helpStr = new StringBuffer("");
		helpStr.append("Usage:\n");
		helpStr.append("Arguments: <filename> [<numSamples>]");
		return helpStr.toString();
	}
	
	public static void main(String[] args) {
		if ((args.length != 1) && (args.length != 2)) {
			System.out.println(getHelp());
		} else {
			try {
				String filename = args[0];
				int numSamples = (args.length==2)?Integer.parseInt(args[1]):HumanBodyARFFWriter.DEFAULT_NUMSAMPLES;
				HumanBodyModel model = new HumanBodyModel();
				Instances dataSet = new Instances("HumanBodyModel", HumanBody.getAttributes(), 0);
				dataSet.setClass(HumanBody.genderA);
				for (int i=0; i<numSamples; i++) {
					HumanBody human = model.getRandomHuman();
					Instance humanInstance = human.getInstance();
					humanInstance.setDataset(dataSet);
					humanInstance.setClassValue((human.getGender()==1)?"M":"F");
					dataSet.add(humanInstance);
				}
				
				ArffSaver saver = new ArffSaver();
				saver.setInstances(dataSet);
				saver.setFile(new File(filename));
				saver.writeBatch();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
