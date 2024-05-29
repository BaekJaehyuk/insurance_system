package 설계.도메인2;


/**
 * @author SW인재육성사업단
 * @version 1.0
 * @created 29-5-2024 오후 10:34:49
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