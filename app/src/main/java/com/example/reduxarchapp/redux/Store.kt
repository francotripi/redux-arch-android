package com.example.reduxarchapp.redux

import org.reduxkotlin.createThreadSafeStore

// Ininitialize the store; reducers found in ./Reducer.kt
val store = createThreadSafeStore(reducer, AppState())
