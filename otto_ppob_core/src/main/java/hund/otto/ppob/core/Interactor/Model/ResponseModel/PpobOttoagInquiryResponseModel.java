package hund.otto.ppob.core.Interactor.Model.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PpobOttoagInquiryResponseModel extends BaseResponseModel {
    PpobOttoagDataModel data;

    public PpobOttoagInquiryResponseModel() {
    }

    public PpobOttoagDataModel getData() {
        return data;
    }

    public void setData(PpobOttoagDataModel data) {
        this.data = data;
    }

    public int getAdminfee() {
        return this.data.adminfee;
    }

    public void setAdminfee(int adminfee) {
        this.data.adminfee = adminfee;
    }

    public int getAmount() {
        return this.data.amount;
    }

    public void setAmount(int amount) {
        this.data.amount = amount;
    }

    public String getHeadva() {
        return this.data.headva;
    }

    public void setHeadva(String headva) {
        this.data.headva = headva;
    }

    public String getMemberid() {
        return this.data.memberid;
    }

    public void setMemberid(String memberid) {
        this.data.memberid = memberid;
    }

    public int getMonths() {
        return this.data.months;
    }

    public void setMonths(int months) {
        this.data.months = months;
    }

    public int getNumfm() {
        return this.data.numfm;
    }

    public void setNumfm(int numfm) {
        this.data.numfm = numfm;
    }

    public String getProductcode() {
        return this.data.productcode;
    }

    public void setProductcode(String productcode) {
        this.data.productcode = productcode;
    }

    public String getRc() {
        return this.data.rc;
    }

    public void setRc(String rc) {
        this.data.rc = rc;
    }

    public String getRrn() {
        return this.data.rrn;
    }

    public void setRrn(String rrn) {
        this.data.rrn = rrn;
    }

    public int getTotalpremium() {
        return this.data.totalpremium;
    }

    public void setTotalpremium(int totalpremium) {
        this.data.totalpremium = totalpremium;
    }

    public String getVa() {
        return this.data.va;
    }

    public void setVa(String va) {
        this.data.va = va;
    }

    public String getMsg() {
        return this.data.msg;
    }

    public void setMsg(String msg) {
        this.data.msg = msg;
    }

    public List<WidgetBuilderModel> getKey_value_list() {
        return this.data.key_value_list;
    }

    public void setKey_value_list(List<WidgetBuilderModel> key_value_list) {
        this.data.key_value_list = key_value_list;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class PpobOttoagDataModel {
    int adminfee;
    int amount;
    String headva;
    String memberid;
    int months;
    String msg;
    int numfm;
    String productcode;
    String rc;
    String rrn;
    int totalpremium;
    //VA is bpjs only
    String va;
    //data model can be ignored, use selected list instead
    List<WidgetBuilderModel> key_value_list;


    public int getAdminfee() {
        return adminfee;
    }

    public void setAdminfee(int adminfee) {
        this.adminfee = adminfee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHeadva() {
        return headva;
    }

    public void setHeadva(String headva) {
        this.headva = headva;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getNumfm() {
        return numfm;
    }

    public void setNumfm(int numfm) {
        this.numfm = numfm;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public int getTotalpremium() {
        return totalpremium;
    }

    public void setTotalpremium(int totalpremium) {
        this.totalpremium = totalpremium;
    }

    public String getVa() {
        return va;
    }

    public void setVa(String va) {
        this.va = va;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<WidgetBuilderModel> getKey_value_list() {
        return key_value_list;
    }

    public void setKey_value_list(List<WidgetBuilderModel> key_value_list) {
        this.key_value_list = key_value_list;
    }
}
