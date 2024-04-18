
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

	
	public int[] ageGropuDistribution(CustomHashTable myTable) {
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
		double[] AgeBasedQuality = new double[4];
		int[] count = new int[4];
		for (CustomHashTable.Entry entry : myTable.table) {
			switch (entry.getValue().getGender()) {
			case "F":
				AgeBasedQuality[0] += entry.getValue().getQuality();
				count[0]++;
				break;
			case "M":
				AgeBasedQuality[1] += entry.getValue().getQuality();
				count[1]++;
				break;
			case "O":
				AgeBasedQuality[2] += entry.getValue().getQuality();
				count[2]++;
				break;
			default:
				AgeBasedQuality[3] += entry.getValue().getQuality();
				count[3]++;
				break;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (count[i] != 0)
				AgeBasedQuality[i] /= (count[i] + 0.0);
		}
		return AgeBasedQuality;
	}
	

	public double[] lifeQualityAgeBased(CustomHashTable myTable) {
	    double[] ageBasedQuality = new double[4];
	    int[] counts = new int[4];
	    for (CustomHashTable.Entry entry : myTable.table) {
	        if (entry != null) {
	            int ageGroup = entry.getValue().getAge();
	            if (ageGroup >= 1 && ageGroup <= 4) {
	                ageBasedQuality[ageGroup - 1] += entry.getValue().getQuality();
	                counts[ageGroup - 1]++;
	            }
	        }
	    }
	    for (int i = 0; i < 4; i++) {
	        if (counts[i] != 0) {
	            ageBasedQuality[i] /= counts[i];
	        }
	    }
	    return ageBasedQuality;
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
	    double[] smokerQuality = new double[2]; 
	    int[] counts = new int[2];
	    for (CustomHashTable.Entry entry : myTable.table) {
	        if (entry != null) {
	            int smoker = entry.getValue().getSmoker();
	            if (smoker == 0 || smoker == 1) {
	                smokerQuality[smoker] += entry.getValue().getQuality();
	                counts[smoker]++;
	            }
	        }
	    }
	    for (int i = 0; i < 2; i++) {
	        if (counts[i] != 0) {
	            smokerQuality[i] /= counts[i];
	        }
	    }
	    return smokerQuality;
	}

	
	public String[] mostCommonTreatment(CustomHashTable myTable) {
		String[] MostCommonTreatment = new String[5];
		int[] treatment = new int[5];
		for (CustomHashTable.Entry entry : myTable.table) {
			if (entry != null) {
				switch (entry.getValue().getQ9()) {
				case "Surgical;Chemotherapy;":
					treatment[0]++;
					break;
				case "Surgical;":
					treatment[1]++;
					break;
				case "MolecularlyTargetedTherapy;":
					treatment[2]++;
					break;
				case "Immunotherapy;":
					treatment[3]++;
					break;
				case "Radiotherapy;Chemotherapy;":
					treatment[4]++;
				}
			}
		}

		for (int i = 0; i < treatment.length; i++) // find the largest number of the treatment, set it to 0, and then
													// record it in the MostCommonTreatment
		{
			int Max = -1;
			int currentMaxIndex = -1;
			for (int j = 0; j < treatment.length; j++) {
				if (treatment[j] > Max) {
					Max = treatment[j];
					currentMaxIndex = j;
				}
			}

			treatment[currentMaxIndex] = -1;
			switch (currentMaxIndex) {
			case 0:
				MostCommonTreatment[i] = "Surgical;Chemotherapy;";
				break;
			case 1:
				MostCommonTreatment[i] = "Surgical;";
				break;
			case 2:
				MostCommonTreatment[i] = "MolecularlyTargetedTherapy;";
				break;
			case 3:
				MostCommonTreatment[i] = "Immunotherapy;";
				break;
			case 4:
				MostCommonTreatment[i] = "Radiotherapy;Chemotherapy;";
				break;
			}
		}

		return MostCommonTreatment;
	}
	
// find the largest number of the treatment, set it to 0, and then
													// record it in the MostCommonTreatment
	
	public static void main(String[] args) {
		

	}

}
