package com.example.ucp2.ui

import com.example.ucp2.ui.data.FormState
import com.example.ucp2.ui.data.Formulir
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class ViewModel :ViewModel() {
    private val _stateUI = MutableStateFlow(Formulir())
    private val _nameSTATE = MutableStateFlow(FormState())
    val stateUI: StateFlow<Formulir> = _stateUI.asStateFlow()
    val nameST : StateFlow<FormState> = _nameSTATE.asStateFlow()

    fun setNama(list: MutableList<String>){
        _nameSTATE.update { stateSaatIni -> stateSaatIni.copy(
            namaa = list[0],
            nim = list[1],
           konservasi = list[2],
            judul = list[3]
        ) }
    }
    
}