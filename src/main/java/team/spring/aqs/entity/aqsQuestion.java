package team.spring.aqs.entity;

import java.util.Date;

public class aqsQuestion {
    private String questionId;

    private String userAccount;

    private String questionIntroduce;

    private Integer questionPreviewCount;

    private Integer questionPraise;

    private Integer questionIfpublic;

    private String questionTypeId;

    private Date questionCreateTime;

    private String questionContent;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getQuestionIntroduce() {
        return questionIntroduce;
    }

    public void setQuestionIntroduce(String questionIntroduce) {
        this.questionIntroduce = questionIntroduce == null ? null : questionIntroduce.trim();
    }

    public Integer getQuestionPreviewCount() {
        return questionPreviewCount;
    }

    public void setQuestionPreviewCount(Integer questionPreviewCount) {
        this.questionPreviewCount = questionPreviewCount;
    }

    public Integer getQuestionPraise() {
        return questionPraise;
    }

    public void setQuestionPraise(Integer questionPraise) {
        this.questionPraise = questionPraise;
    }

    public Integer getQuestionIfpublic() {
        return questionIfpublic;
    }

    public void setQuestionIfpublic(Integer questionIfpublic) {
        this.questionIfpublic = questionIfpublic;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId == null ? null : questionTypeId.trim();
    }

    public Date getQuestionCreateTime() {
        return questionCreateTime;
    }

    public void setQuestionCreateTime(Date questionCreateTime) {
        this.questionCreateTime = questionCreateTime;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

	@Override
	public String toString() {
		return "aqsQuestion [questionId=" + questionId + ", userAccount=" + userAccount + ", questionIntroduce="
				+ questionIntroduce + ", questionPreviewCount=" + questionPreviewCount + ", questionPraise="
				+ questionPraise + ", questionIfpublic=" + questionIfpublic + ", questionTypeId=" + questionTypeId
				+ ", questionCreateTime=" + questionCreateTime + ", questionContent=" + questionContent + "]";
	}
    
    
}