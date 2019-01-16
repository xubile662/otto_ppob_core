package hund.otto.ppob.core.Interactor.Model.Misc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentData {

    @JsonProperty("key_value_list")
    private List<WidgetBuilderModel> keyValueList;

    public List<WidgetBuilderModel> getKeyValueList() {
        return keyValueList;
    }

    public void setKeyValueList(List<WidgetBuilderModel> keyValueList) {
        this.keyValueList = keyValueList;
    }
}
