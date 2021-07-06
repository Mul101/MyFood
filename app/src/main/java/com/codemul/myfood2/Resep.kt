package com.codemul.myfood2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import androidx.versionedparcelable.VersionedParcelize

//Data class adalah sebuah kelas yang tidak memiliki logika apapun
// dan juga tidak memiliki fungsionalitas lain selain menangani data
//Hanya dengan satu baris kode di atas, kompiler akan secara otomatis menghasilkan
// constructor, toString(), equals(), hashCode(), copy() dan juga fungsi componentN(). T

//TIDAK PERLU MEMBUAT DATA CLASS karena nanti akan error
@Parcelize
data class Resep(
    var name: String = "",
    var images: Int = 0,
    var step_resep: String = ""
) : Parcelable

//Untuk bahasa Kotlin, Anda sudah bisa memanfaatkan
// constructor, getter, dan setter secara otomatis dari sebuah data classes .