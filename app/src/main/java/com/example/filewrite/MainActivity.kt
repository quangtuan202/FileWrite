package com.example.filewrite

import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.storage.StorageManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.filewrite.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream


const val CREATE_FILE = 1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ActivityCompat.requestPermissions(
            this, arrayOf( WRITE_EXTERNAL_STORAGE),
            PackageManager.PERMISSION_GRANTED
        )

        binding.button.setOnClickListener {
            // Create an intent with the ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION action.
            // Create an intent with the ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION action.
//            if(!Environment.isExternalStorageManager()) {
//                val intent = Intent(ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
//                startActivity(intent)
//            }


            createFile(null)

        }
    }



    @RequiresApi(Build.VERSION_CODES.R)
    private fun createFile(pickerInitialUri: Uri?) {
        val storageManager = getSystemService(STORAGE_SERVICE) as StorageManager
        val storageVolume = storageManager.storageVolumes[0] // internal Storage

        val fileInputImage = File(storageVolume.directory!!.path + "/Download/test.txt")
        val str="aaaaaa"
//        val byteArray= str.toByteArray()
        val fos= FileOutputStream(fileInputImage)
        fos.write(str.toByteArray())
//        fileInputImage.writeBytes(byteArray)
//
//        fileInputImage.writeText("aaaaaaa")
    }

}