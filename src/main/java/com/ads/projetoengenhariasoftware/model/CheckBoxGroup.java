package com.ads.projetoengenhariasoftware.model;

import javafx.scene.control.CheckBox;

import java.util.HashMap;
import java.util.Map;

public class CheckBoxGroup<T extends Enum<T>> {
    private final Map<T, CheckBox> checkBoxMap = new HashMap<>();

    public void addMapping(T enumValue, CheckBox checkBox) {
        checkBoxMap.put(enumValue, checkBox);
        checkBox.setOnAction(event -> handleCheckBoxAction(checkBox));
    }

    private void handleCheckBoxAction(CheckBox selectedCheckBox) {
        for (CheckBox checkBox : checkBoxMap.values()) {
            if (checkBox != selectedCheckBox) {
                checkBox.setSelected(false);
            }
        }
    }

    public T getSelected() {
        for (Map.Entry<T, CheckBox> entry : checkBoxMap.entrySet()) {
            if (entry.getValue().isSelected()) {
                return entry.getKey();
            }
        }
        return null; // Nenhum selecionado
    }

}
