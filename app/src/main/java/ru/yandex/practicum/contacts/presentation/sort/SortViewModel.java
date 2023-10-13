package ru.yandex.practicum.contacts.presentation.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.yandex.practicum.contacts.presentation.base.BaseBottomSheetViewModel;
import ru.yandex.practicum.contacts.presentation.sort.model.SortType;

import androidx.lifecycle.MutableLiveData;

public class SortViewModel extends BaseBottomSheetViewModel {

    private final SortUiState uiState = new SortUiState();
    private final MutableLiveData<List<SortTypeUI>> sortTypesLiveDate = new MutableLiveData<>();
    private final MutableLiveData<SortUiState> uiStateLiveDate = new MutableLiveData<>();

    private String defaultSortType;
    private String selectedSortType;

    public void init(String defaultSortType) {
        this.defaultSortType = defaultSortType;
        this.selectedSortType = defaultSortType;
        updateSortTypes();
        updateUiState();
    }

    public void onSortTypeItemClick(SortTypeUI sortType) {
        selectedSortType = sortType.getSortType();
        updateSortTypes();
        updateUiState();
    }

    @Override
    public void onApplyClick() {
        uiState.setNewSelectedSortType(selectedSortType);
        updateUiState();
    }

    @Override
    public void onResetClick() {
        selectedSortType = defaultSortType;
        updateSortTypes();
        updateUiState();
    }

    public MutableLiveData<List<SortTypeUI>> getSortTypesLiveDate() {
        return sortTypesLiveDate;
    }

    public MutableLiveData<SortUiState> getUiStateLiveDate() {
        return uiStateLiveDate;
    }

    private void updateSortTypes() {
        final String[] sortTypes = {SortType.BY_NAME, SortType.BY_NAME_REVERSED, SortType.BY_SURNAME, SortType.BY_SURNAME_REVERSED};
        final List<SortTypeUI> sortTypesUi = Arrays.stream(sortTypes)
                .map(sortType -> new SortTypeUI(sortType, Objects.equals(sortType, selectedSortType)))
                .collect(Collectors.toList());
        sortTypesLiveDate.setValue(sortTypesUi);
    }

    private void updateUiState() {
        uiState.setApplyEnable(!defaultSortType.equals(selectedSortType));
        uiStateLiveDate.setValue(uiState);
    }
}
