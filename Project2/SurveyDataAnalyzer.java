public class SurveyDataAnalyzer {

	public int[] genderDistribution(CustomHashTable myTable) {
		int[] numberOfGender = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				switch (entry.getValue().getGender()) {
				case "F":
					numberOfGender[0]++;
					break;
				case "M":
					numberOfGender[1]++;
					break;
				case "O":
					numberOfGender[2]++;
					break;
				default:
					numberOfGender[3]++;
					break;
				}
			}
		}
		return numberOfGender;
	}

	public int[] ageGroupDistribution(CustomHashTable myTable) {
		int[] numberOfAge = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				switch (entry.getValue().getAge()) {
				case 1:
					numberOfAge[0]++;
					break;
				case 2:
					numberOfAge[1]++;
					break;
				case 3:
					numberOfAge[2]++;
					break;
				case 4:
					numberOfAge[3]++;
					break;
				}
			}
		}
		return numberOfAge;
	}

	public int[] residenceDistribution(CustomHashTable myTable) {
		int[] numberOfResidence = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				switch (entry.getValue().getResidence()) {
				case 1:
					numberOfResidence[0]++;
					break;
				case 2:
					numberOfResidence[1]++;
					break;
				case 3:
					numberOfResidence[2]++;
					break;
				case 4:
					numberOfResidence[3]++;
					break;
				}
			}
		}
		return numberOfResidence;
	}

	public int[] educationDistribution(CustomHashTable myTable) {
		int[] numberOfEducation = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				switch (entry.getValue().getEducation()) {
				case 1:
					numberOfEducation[0]++;
					break;
				case 2:
					numberOfEducation[1]++;
					break;
				case 3:
					numberOfEducation[2]++;
					break;
				case 4:
					numberOfEducation[3]++;
					break;
				}
			}
		}
		return numberOfEducation;
	}

	public int[] incomeDistribution(CustomHashTable myTable) {
		int[] incomeCounts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int incomeType = entry.getValue().getIncomeSource();
				if (incomeType >= 1 && incomeType <= 4) {
					incomeCounts[incomeType - 1]++;
				}
			}
		}
		return incomeCounts;
	}

	public int[] maritalDistribution(CustomHashTable myTable) {
		int[] maritalCounts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int status = entry.getValue().getMaritalStatus();
				if (status >= 1 && status <= 4) {
					maritalCounts[status - 1]++;
				}
			}
		}
		return maritalCounts;
	}

	public int[] smokerDistribution(CustomHashTable myTable) {
		int[] smokerCounts = new int[2];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int smoker = entry.getValue().getSmoker();
				if (smoker == 0 || smoker == 1) {
					smokerCounts[smoker]++;
				}
			}
		}
		return smokerCounts;
	}

	public double lifeQualityGeneral(CustomHashTable myTable) {
		double totalQuality = 0.0;
		int count = 0;
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				count++;
				totalQuality += entry.getValue().getQuality();
			}
		}
		if (count == 0)
			return 0.0;
		else
			return totalQuality / (count + 0.0);
	}

	public double[] lifeQualityGenderBased(CustomHashTable myTable) {
		double[] genderQuality = new double[4];
		int[] counts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				switch (entry.getValue().getGender()) {
				case "F":
					genderQuality[0] += entry.getValue().getQuality();
					counts[0]++;
					break;
				case "M":
					genderQuality[1] += entry.getValue().getQuality();
					counts[1]++;
					break;
				case "O":
					genderQuality[2] += entry.getValue().getQuality();
					counts[2]++;
					break;
				default:
					genderQuality[3] += entry.getValue().getQuality();
					counts[3]++;
					break;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (counts[i] != 0) {
				genderQuality[i] /= counts[i];
			}
		}
		return genderQuality;
	}

	public double[] lifeQualityAgeBased(CustomHashTable myTable) {
		double[] ageQuality = new double[4];
		int[] counts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int ageGroup = entry.getValue().getAge();
				if (ageGroup >= 1 && ageGroup <= 4) {
					ageQuality[ageGroup - 1] += entry.getValue().getQuality();
					counts[ageGroup - 1]++;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (counts[i] != 0) {
				ageQuality[i] /= counts[i];
			}
		}
		return ageQuality;
	}

	public double[] lifeQualityResidenceBased(CustomHashTable myTable) {
		double[] residenceQuality = new double[4];
		int[] counts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int residence = entry.getValue().getResidence();
				if (residence >= 1 && residence <= 4) {
					residenceQuality[residence - 1] += entry.getValue().getQuality();
					counts[residence - 1]++;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (counts[i] != 0) {
				residenceQuality[i] /= counts[i];
			}
		}
		return residenceQuality;
	}

	public double[] lifeQualityEducationBased(CustomHashTable myTable) {
		double[] educationQuality = new double[4];
		int[] counts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int education = entry.getValue().getEducation();
				if (education >= 1 && education <= 4) {
					educationQuality[education - 1] += entry.getValue().getQuality();
					counts[education - 1]++;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (counts[i] != 0) {
				educationQuality[i] /= counts[i];
			}
		}
		return educationQuality;
	}

	public double[] lifeQualityIncomeBased(CustomHashTable myTable) {
		double[] incomeQuality = new double[4];
		int[] counts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int income = entry.getValue().getIncomeSource();
				if (income >= 1 && income <= 4) {
					incomeQuality[income - 1] += entry.getValue().getQuality();
					counts[income - 1]++;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (counts[i] != 0) {
				incomeQuality[i] /= counts[i];
			}
		}
		return incomeQuality;
	}

	public double[] lifeQualityMaritalBased(CustomHashTable myTable) {
		double[] maritalQuality = new double[4];
		int[] counts = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				int maritalStatus = entry.getValue().getMaritalStatus();
				if (maritalStatus >= 1 && maritalStatus <= 4) {
					maritalQuality[maritalStatus - 1] += entry.getValue().getQuality();
					counts[maritalStatus - 1]++;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (counts[i] != 0) {
				maritalQuality[i] /= counts[i];
			}
		}
		return maritalQuality;
	}

	public double[] lifeQualitySmokerBased(CustomHashTable myTable) {
		double[] qualityBySmoker = new double[2];
		int[] smokerCount = new int[2];

		for (int i = 0; i < myTable.table.length; i++) {
			if (myTable.table[i] != null) {
				Response response = myTable.table[i].getValue();
				int smoker = response.getSmoker();
				int index = smoker == 1 ? 0 : 1;
				qualityBySmoker[index] += response.getQuality();
				smokerCount[index]++;
			}
		}
		// Calculate average quality for each smoker status
		for (int i = 0; i < qualityBySmoker.length; i++) {
			if (smokerCount[i] > 0) {
				qualityBySmoker[i] /= smokerCount[i];
			}
		}
		return qualityBySmoker;
	}

	public String[] mostCommonTreatment(CustomHashTable myTable) {
		String[] treatments = new String[] { "Surgical", "Chemotherapy", "Radiotherapy", "Immunotherapy",
				"MolecularlyTargetedTherapy" };
		int[] treatmentCounts = new int[5];

		// Count occurrences of each treatment
		for (int i = 0; i < myTable.table.length; i++) {
			if (myTable.table[i] != null) {
				String[] responses = myTable.table[i].getValue().getQ9().split(";");
				for (String response : responses) {
					response = response.trim();
					for (int j = 0; j < treatments.length; j++) {
						if (response.equals(treatments[j])) {
							treatmentCounts[j]++;
							break;
						}
					}
				}
			}
		}

		// Sort treatments based on counts
		for (int i = 0; i < treatmentCounts.length - 1; i++) {
			for (int j = i + 1; j < treatmentCounts.length; j++) {
				if (treatmentCounts[j] > treatmentCounts[i]) {
					int tempCount = treatmentCounts[i];
					treatmentCounts[i] = treatmentCounts[j];
					treatmentCounts[j] = tempCount;
					String tempTreatment = treatments[i];
					treatments[i] = treatments[j];
					treatments[j] = tempTreatment;
				}
			}
		}

		// Return the sorted treatments
		return treatments;
	}

	public String[] mostCommonSymptoms(CustomHashTable myTable) {
		String[] symptoms = new String[] { "Cough", "Hoarseness", "CoughingUpBlood", "ChestPain", "ShortnessOfBreath",
				"Weakness", "None" };
		int[] symptomCounts = new int[7];

		// Count occurrences of each symptom
		for (int i = 0; i < myTable.table.length; i++) {
			if (myTable.table[i] != null) {
				String[] responses = myTable.table[i].getValue().getQ16().split(";");
				for (String response : responses) {
					response = response.trim();
					for (int j = 0; j < symptoms.length; j++) {
						if (response.equals(symptoms[j])) {
							symptomCounts[j]++;
							break;
						}
					}
				}
			}
		}

		// Sort symptoms based on counts
		for (int i = 0; i < symptomCounts.length - 1; i++) {
			for (int j = i + 1; j < symptomCounts.length; j++) {
				if (symptomCounts[j] > symptomCounts[i]) {
					int tempCount = symptomCounts[i];
					symptomCounts[i] = symptomCounts[j];
					symptomCounts[j] = tempCount;
					String tempSymptom = symptoms[i];
					symptoms[i] = symptoms[j];
					symptoms[j] = tempSymptom;
				}
			}
		}

		// Return the sorted symptoms
		return symptoms;
	}

	public String[] mostCommonLifeAspects(CustomHashTable myTable) {
		String[] aspects = new String[] { "PhysicalAspect", "PsychologicalAspect", "ProfessionalLife", "FamilyLife",
				"SocialLife", "DoesNotAffect" };
		int[] aspectCounts = new int[6];

		// Count occurrences of each aspect
		for (int i = 0; i < myTable.table.length; i++) {
			if (myTable.table[i] != null) {
				String[] responses = myTable.table[i].getValue().getQ23().split(";");
				for (String response : responses) {
					response = response.trim();
					for (int j = 0; j < aspects.length; j++) {
						if (response.equals(aspects[j])) {
							aspectCounts[j]++;
							break;
						}
					}
				}
			}
		}

		// Sort aspects based on counts
		for (int i = 0; i < aspectCounts.length - 1; i++) {
			for (int j = i + 1; j < aspectCounts.length; j++) {
				if (aspectCounts[j] > aspectCounts[i]) {
					int tempCount = aspectCounts[i];
					aspectCounts[i] = aspectCounts[j];
					aspectCounts[j] = tempCount;
					String tempAspect = aspects[i];
					aspects[i] = aspects[j];
					aspects[j] = tempAspect;
				}
			}
		}

		// Return the sorted aspects
		return aspects;
	}

	public double[] lifeQualityMixConditionsBased(CustomHashTable myTable) {
		double[] qualityAverages = new double[2];
		int[] counts = new int[2];
		double[] totalQuality = new double[2];

		// Calculate total quality and counts for each condition
		for (int i = 0; i < myTable.table.length; i++) {
			if (myTable.table[i] != null) {
				Response response = myTable.table[i].getValue();
				double quality = response.getQuality();
				int residence = response.getResidence();
				int maritalStatus = response.getMaritalStatus();

				if (maritalStatus == 1 && residence == 4) {
					totalQuality[0] += quality;
					counts[0]++;
				} else if (maritalStatus == 2 && (residence == 1 || residence == 2)) {
					totalQuality[1] += quality;
					counts[1]++;
				}
			}
		}

		// Calculate averages
		for (int i = 0; i < 2; i++) {
			if (counts[i] > 0) {
				qualityAverages[i] = totalQuality[i] / counts[i];
			}
		}

		return qualityAverages;
	}

	public double[] lifeQualityResponseBased(CustomHashTable myTable) {
		double[] qualityAverages = new double[4];
		int[] counts = new int[4];
		double[] totalQuality = new double[4];

		// Calculate total quality and counts for each response
		for (int i = 0; i < myTable.table.length; i++) {
			if (myTable.table[i] != null) {
				Response response = myTable.table[i].getValue();
				int response15 = response.getQ15();
				double quality = response.getQuality();

				switch (response15) {
				case 1: // Very good
					totalQuality[0] += quality;
					counts[0]++;
					break;
				case 2: // Good
					totalQuality[1] += quality;
					counts[1]++;
					break;
				case 3: // Bad
					totalQuality[2] += quality;
					counts[2]++;
					break;
				case 4: // Very bad
					totalQuality[3] += quality;
					counts[3]++;
					break;
				}
			}
		}

		// Calculate averages
		for (int i = 0; i < 4; i++) {
			if (counts[i] > 0) {
				qualityAverages[i] = totalQuality[i] / counts[i];
			}
		}

		return qualityAverages;
	}

	public static void main(String[] args) {
		// Read responses.txt
		CustomHashTable myTable = ReadFile.readResponsesFromFile("responses.txt");

		// Create a SurveyDataAnalyzer instance
		SurveyDataAnalyzer analyzer = new SurveyDataAnalyzer();

		// Gender Distribution
		int[] genderDistribution = analyzer.genderDistribution(myTable);
		System.out.println("Gender Distribution:");
		System.out.println("Females: " + genderDistribution[0]);
		System.out.println("Males: " + genderDistribution[1]);
		System.out.println("Others: " + genderDistribution[2]);
		System.out.println("Unknown: " + genderDistribution[3]);

		// Age Group Distribution
		int[] ageGroupDistribution = analyzer.ageGroupDistribution(myTable);
		System.out.println("\nAge Group Distribution:");
		System.out.println("Group 1: " + ageGroupDistribution[0]);
		System.out.println("Group 2: " + ageGroupDistribution[1]);
		System.out.println("Group 3: " + ageGroupDistribution[2]);
		System.out.println("Group 4: " + ageGroupDistribution[3]);

		// Residence Distribution
		int[] residenceDistribution = analyzer.residenceDistribution(myTable);
		System.out.println("\nResidence Distribution:");
		System.out.println("Type 1: " + residenceDistribution[0]);
		System.out.println("Type 2: " + residenceDistribution[1]);
		System.out.println("Type 3: " + residenceDistribution[2]);
		System.out.println("Type 4: " + residenceDistribution[3]);

		// Education Distribution
		int[] educationDistribution = analyzer.educationDistribution(myTable);
		System.out.println("\nEducation Distribution:");
		System.out.println("Level 1: " + educationDistribution[0]);
		System.out.println("Level 2: " + educationDistribution[1]);
		System.out.println("Level 3: " + educationDistribution[2]);
		System.out.println("Level 4: " + educationDistribution[3]);

		// Income Distribution
		int[] incomeDistribution = analyzer.incomeDistribution(myTable);
		System.out.println("\nIncome Distribution:");
		System.out.println("Source 1: " + incomeDistribution[0]);
		System.out.println("Source 2: " + incomeDistribution[1]);
		System.out.println("Source 3: " + incomeDistribution[2]);
		System.out.println("Source 4: " + incomeDistribution[3]);

		// Marital Distribution
		int[] maritalDistribution = analyzer.maritalDistribution(myTable);
		System.out.println("\nMarital Distribution:");
		System.out.println("Status 1: " + maritalDistribution[0]);
		System.out.println("Status 2: " + maritalDistribution[1]);
		System.out.println("Status 3: " + maritalDistribution[2]);
		System.out.println("Status 4: " + maritalDistribution[3]);

		// Smoker Distribution
		int[] smokerDistribution = analyzer.smokerDistribution(myTable);
		System.out.println("\nSmoker Distribution:");
		System.out.println("Non-Smokers: " + smokerDistribution[0]);
		System.out.println("Smokers: " + smokerDistribution[1]);

		// General Life Quality
		double lifeQualityGeneral = analyzer.lifeQualityGeneral(myTable);
		System.out.println("\nGeneral Life Quality:");
		System.out.println("Average Quality: " + lifeQualityGeneral);

		// Gender-Based Life Quality
		double[] lifeQualityGenderBased = analyzer.lifeQualityGenderBased(myTable);
		System.out.println("\nGender-Based Life Quality:");
		System.out.println("Female Quality: " + lifeQualityGenderBased[0]);
		System.out.println("Male Quality: " + lifeQualityGenderBased[1]);
		System.out.println("Other Quality: " + lifeQualityGenderBased[2]);
		System.out.println("Unknown Gender Quality: " + lifeQualityGenderBased[3]);

		// Age-Based Life Quality
		double[] lifeQualityAgeBased = analyzer.lifeQualityAgeBased(myTable);
		System.out.println("\nAge-Based Life Quality:");
		System.out.println("Group 1 Quality: " + lifeQualityAgeBased[0]);
		System.out.println("Group 2 Quality: " + lifeQualityAgeBased[1]);
		System.out.println("Group 3 Quality: " + lifeQualityAgeBased[2]);
		System.out.println("Group 4 Quality: " + lifeQualityAgeBased[3]);

		// Residence-Based Life Quality
		double[] lifeQualityResidenceBased = analyzer.lifeQualityResidenceBased(myTable);
		System.out.println("\nResidence-Based Life Quality:");
		System.out.println("Type 1 Quality: " + lifeQualityResidenceBased[0]);
		System.out.println("Type 2 Quality: " + lifeQualityResidenceBased[1]);
		System.out.println("Type 3 Quality: " + lifeQualityResidenceBased[2]);
		System.out.println("Type 4 Quality: " + lifeQualityResidenceBased[3]);

		// Education-Based Life Quality
		double[] lifeQualityEducationBased = analyzer.lifeQualityEducationBased(myTable);
		System.out.println("\nEducation-Based Life Quality:");
		System.out.println("Level 1 Quality: " + lifeQualityEducationBased[0]);
		System.out.println("Level 2 Quality: " + lifeQualityEducationBased[1]);
		System.out.println("Level 3 Quality: " + lifeQualityEducationBased[2]);
		System.out.println("Level 4 Quality: " + lifeQualityEducationBased[3]);

		// Income-Based Life Quality
		double[] lifeQualityIncomeBased = analyzer.lifeQualityIncomeBased(myTable);
		System.out.println("\nIncome-Based Life Quality:");
		System.out.println("Source 1 Quality: " + lifeQualityIncomeBased[0]);
		System.out.println("Source 2 Quality: " + lifeQualityIncomeBased[1]);
		System.out.println("Source 3 Quality: " + lifeQualityIncomeBased[2]);
		System.out.println("Source 4 Quality: " + lifeQualityIncomeBased[3]);

		// Marital-Based Life Quality
		double[] lifeQualityMaritalBased = analyzer.lifeQualityMaritalBased(myTable);
		System.out.println("\nMarital-Based Life Quality:");
		System.out.println("Status 1 Quality: " + lifeQualityMaritalBased[0]);
		System.out.println("Status 2 Quality: " + lifeQualityMaritalBased[1]);
		System.out.println("Status 3 Quality: " + lifeQualityMaritalBased[2]);
		System.out.println("Status 4 Quality: " + lifeQualityMaritalBased[3]);

		// Smoker-Based Life Quality
		double[] lifeQualitySmokerBased = analyzer.lifeQualitySmokerBased(myTable);
		System.out.println("\nSmoker-Based Life Quality:");
		System.out.println("Non-Smoker Quality: " + lifeQualitySmokerBased[1]);
		System.out.println("Smoker Quality: " + lifeQualitySmokerBased[0]);

		// Common Treatments
		String[] commonTreatments = analyzer.mostCommonTreatment(myTable);
		System.out.println("\nMost Common Treatments:");
		System.out.println("1. " + commonTreatments[0]);
		System.out.println("2. " + commonTreatments[1]);
		System.out.println("3. " + commonTreatments[2]);
		System.out.println("4. " + commonTreatments[3]);
		System.out.println("5. " + commonTreatments[4]);

		// Common Symptoms
		String[] commonSymptoms = analyzer.mostCommonSymptoms(myTable);
		System.out.println("\nMost Common Symptoms:");
		System.out.println("1. " + commonSymptoms[0]);
		System.out.println("2. " + commonSymptoms[1]);
		System.out.println("3. " + commonSymptoms[2]);
		System.out.println("4. " + commonSymptoms[3]);
		System.out.println("5. " + commonSymptoms[4]);
		System.out.println("6. " + commonSymptoms[5]);
		System.out.println("7. " + commonSymptoms[6]);

		// Common Life Aspects
		String[] commonLifeAspects = analyzer.mostCommonLifeAspects(myTable);
		System.out.println("\nMost Common Life Aspects:");
		System.out.println("1. " + commonLifeAspects[0]);
		System.out.println("2. " + commonLifeAspects[1]);
		System.out.println("3. " + commonLifeAspects[2]);
		System.out.println("4. " + commonLifeAspects[3]);
		System.out.println("5. " + commonLifeAspects[4]);
		System.out.println("6. " + commonLifeAspects[5]);

		// Life Quality Based on Mix Conditions
		double[] lifeQualityMixConditionsBased = analyzer.lifeQualityMixConditionsBased(myTable);
		System.out.println("\nLife Quality Based on Mix Conditions:");
		System.out.println("Group 1 Quality: " + lifeQualityMixConditionsBased[0]);
		System.out.println("Group 2 Quality: " + lifeQualityMixConditionsBased[1]);

		// Life Quality Based on Response 15
		double[] lifeQualityResponseBased = analyzer.lifeQualityResponseBased(myTable);
		System.out.println("\nLife Quality Based on Response 15:");
		System.out.println("Very Good Quality: " + lifeQualityResponseBased[0]);
		System.out.println("Good Quality: " + lifeQualityResponseBased[1]);
		System.out.println("Bad Quality: " + lifeQualityResponseBased[2]);
		System.out.println("Very Bad Quality: " + lifeQualityResponseBased[3]);
	}

}