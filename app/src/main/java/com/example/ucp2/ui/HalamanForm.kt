@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ucp2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonCLicked: () -> Unit
){

    var namaText by remember {
        mutableStateOf("")
    }
    var nimText by remember {
        mutableStateOf("")
    }
    var konservasiText by remember {
        mutableStateOf("")
    }
    var judulText by remember {
        mutableStateOf("")
        }

    var listData: MutableList<String> = mutableListOf(namaText, nimText, konservasiText,judulText)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulir Pengajuan Skripsi", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = namaText,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.nama_mhs)) },
                onValueChange = {namaText = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nimText,
                shape = MaterialTheme.shapes.large,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(text = stringResource(id = R.string.nim_mhs)) },
                onValueChange = {nimText = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = konservasiText,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.konservasi_mhs)) },
                onValueChange = {konservasiText = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = judulText,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.judul_skripsi)) },
                onValueChange = {judulText = it}
            )


            Spacer(modifier = Modifier.padding(10.dp))
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(onClick = {onBackButtonCLicked}) {
                Text(text = stringResource(id = R.string.btn_back))
            }
            Button(onClick = {onSubmitButtonClicked(listData)}) {
                Text(text = stringResource(id = R.string.btn_submit))
            }
        }
    }
}
