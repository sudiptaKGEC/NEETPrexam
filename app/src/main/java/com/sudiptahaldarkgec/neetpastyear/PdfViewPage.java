package com.sudiptahaldarkgec.neetpastyear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewPage extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view_page);

        pdfView = findViewById(R.id.pdfViewId);


        int storyNumber = getIntent().getIntExtra("key_position", 0);

        if(storyNumber==0){
            pdfView.fromAsset("2022.pdf").load();
        }
        else if(storyNumber==1){
            pdfView.fromAsset("2021.pdf").load();
        }
        else if(storyNumber==2){
            pdfView.fromAsset("2020.pdf").load();
        }
        else if(storyNumber==3){
            pdfView.fromAsset("2019.pdf").load();
        }
        else if(storyNumber==4){
            pdfView.fromAsset("2018.pdf").load();
        }
        else if(storyNumber==5){
            pdfView.fromAsset("2017.pdf").load();
        }
        else if(storyNumber==6){
            pdfView.fromAsset("2016.pdf").load();
        }
        else if(storyNumber==7){
            pdfView.fromAsset("2015.pdf").load();
        }
        else if(storyNumber==8){
            pdfView.fromAsset("2014.pdf").load();
        }
        else if(storyNumber==9){
            pdfView.fromAsset("2013.pdf").load();
        }
        else if(storyNumber==10){
            pdfView.fromAsset("2012.pdf").load();
        }
        else if(storyNumber==11){
            pdfView.fromAsset("2011.pdf").load();
        }
        else if(storyNumber==12){
            pdfView.fromAsset("2010.pdf").load();
        }
        else if(storyNumber==13){
            pdfView.fromAsset("2009.pdf").load();
        }
        else if(storyNumber==14){
            pdfView.fromAsset("2008.pdf").load();
        }
        else if(storyNumber==15){
            pdfView.fromAsset("2007.pdf").load();
        }
    }
}