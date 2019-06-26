package team.spring.aqs.entity;

public class aqsQuestionType {
    private String quesitonTypeId;

    private String questionTypeName;

    public String getQuesitonTypeId() {
        return quesitonTypeId;
    }

    public void setQuesitonTypeId(String quesitonTypeId) {
        this.quesitonTypeId = quesitonTypeId == null ? null : quesitonTypeId.trim();
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName == null ? null : questionTypeName.trim();
    }
}