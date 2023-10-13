package ru.yandex.practicum.contacts.presentation.sort;

// класс UiState должен иметь package-private доступ
class SortUiState {

    // сделайте поля isApplyEnable и newSelectedSortType приватными
    private boolean isApplyEnable = false;
    private String newSelectedSortType = null;

    // реализуйте get и set методы для обоих полей

    public boolean getApplyEnable(){
        return this.isApplyEnable;
    }

    public String getNewSelectedSortType(){
        return this.newSelectedSortType;
    }

    public void setApplyEnable(boolean isApplyEnable){
        this.isApplyEnable = isApplyEnable;
    }

    public void setNewSelectedSortType(String newSelectedSortType){
        this.newSelectedSortType = newSelectedSortType;
    }
}
