package src.system;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:49
 */
public class Applicant {

	private int applicantID;
	private Career careerS;
	private int coverLetter;
	private PersonalInformation personalInformation;
	public Career m_Career;
	public PersonalInformation m_PersonalInformation;
	public Employment m_Employment;
	public Interview  m_Interview ;

	public Applicant(){

	}

	public void finalize() throws Throwable {

	}

}