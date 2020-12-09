package com.edu.movie.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cast(val id: Int?, val name: String?, val imageUrl: String?) : Parcelable

object CastEntry {
    const val LIST_CASTS = "cast"
    const val ID = "id"
    const val NAME = "name"
    const val IMAGE_URL = "profile_path"
}
