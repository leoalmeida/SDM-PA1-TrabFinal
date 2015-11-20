package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;
import br.edu.ifspsaocarlos.sdm.trabalhofinal.parser.XMLParser;

public class QuizDificil extends Activity implements View.OnClickListener{

    //private ArrayList<ImageView> mImages = new ArrayList<ImageView>();
    private ArrayList<Button> mButtons = new ArrayList<Button>();
    private int[] letras = new int[10];
    private int quantLetras=0, tamanhoResp=0,fase=0,tamanhoBase=0;
    private String respCerta="",respEscolhida="";

    @Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizdificil);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();

        fase = intent.getIntExtra("fase",0);

        TextView tv = (TextView) findViewById(R.id.tvFaseForca);
        tv.setText("Fase " + new Integer(fase+1));

        Resources res = getResources();
        // Busca o Asset XML responsável por guardar as informações das fase
        XmlResourceParser resourceParser = res.getXml(R.xml.racas);

        Document doc = null; // Buscando o elemento DOM
        try {
            doc = XMLParser.getXmlFromResource(resourceParser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NodeList nl = doc.getElementsByTagName(getString(R.string.KEY_OPTION)); //Busca todos os elementos com a TAG Option
        tamanhoBase = nl.getLength();
        Element e = (Element) nl.item(fase); //Busca o elemento da fase atual
        respCerta = XMLParser.getValue(e, getString(R.string.KEY_TITULO)).toUpperCase(); // Busca no nome da raça da fase atual
        String imgPath = XMLParser.getValue(e, getString(R.string.KEY_IMAGEM)); //Busca o path da imagem

        ImageView iv =(ImageView)findViewById(R.id.ivForca);
        iv.setImageURI(Uri.parse(imgPath));

        tamanhoResp = respCerta.length();

        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutResposta);
        ImageView imageView;

        for (int letra=0;letra<tamanhoResp;letra++){
            imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_semletra);
            imageView.setId(letra+1);
            imageView.setOnClickListener(this);
            //mImages.add(imageView);
            layout.addView(imageView);
        }

        LinearLayout layoutLetras1 = (LinearLayout) findViewById(R.id.layoutLetras1);
        LinearLayout layoutLetras2 = (LinearLayout) findViewById(R.id.layoutLetras2);
        Button button;

        //Gerando número randomico para a posição da resposta certa
        Random numRand = new Random();
        int letra,count=0,innerCount=0;
        for (int i=0;i<10;i++)letras[i]=0;
        while (innerCount<respCerta.length()){
            letra = numRand.nextInt(10);
            if (letras[letra]>0)continue;
            letras[letra] = Character.toUpperCase(respCerta.charAt(innerCount));
            innerCount++;
        }
        while (count<10){
            if (letras[count]>0) {
                count++;
                continue;
            }
            letra = numRand.nextInt(26) +65;
            letras[count] = letra;
            count++;
        }

        for (count=0;count<5;count++){
            button = new Button(this);
            button.setWidth(70);
            button.setHeight(70);
            button.setText(Character.toString((char) letras[count]));
            button.setOnClickListener(this);
            mButtons.add(button);
            layoutLetras1.addView(mButtons.get(count));
        }
        for (count=5;count<10;count++){
            button = new Button(this);
            button.setWidth(70);
            button.setHeight(70);
            button.setText(Character.toString ((char)letras[count]));
            button.setOnClickListener(this);
            mButtons.add(button);
            layoutLetras2.addView(mButtons.get(count));
        }

        //button = new Button(this);
        //button.setId(0);
       // button.setText("Desfazer");
        //button.setOnClickListener(this);

        //layoutLetras2.addView(button);


    }

    @Override
    public void onClick(View v) {
        if (quantLetras>=tamanhoResp) return;
        if (v.getId()==0){
            if(quantLetras<=0) return;
            ImageView imageView = (ImageView) findViewById(quantLetras);
            imageView.setImageResource(R.drawable.ic_semletra);
            for (int index=0;index<10;index++){
                Button button = mButtons.get(index);
                if (respEscolhida.substring(quantLetras-1,quantLetras).compareTo(button.getText().toString())==0 && !button.isShown()){
                    button.setVisibility(View.VISIBLE);
                    break;
                }
            }
            respEscolhida = respEscolhida.substring(0,quantLetras-1);
            quantLetras--;
            return;
        }
        if (v.getId()>respEscolhida.length() && v.getId()<=tamanhoResp) return;
        if (v.getId()>0 && v.getId()<=respEscolhida.length() ){
            if (respEscolhida.substring(v.getId()-1,v.getId()).compareTo(" ") == 0) return;
            ImageView imageView = (ImageView) v;
            imageView.setImageResource(R.drawable.ic_semletra);
            for (int index=0;index<10;index++){
                Button button = mButtons.get(index);
                if (respEscolhida.substring(v.getId()-1,v.getId()).compareTo(button.getText().toString())==0 && !button.isShown()){
                    button.setVisibility(View.VISIBLE);
                    break;
                }
            }
            if (v.getId()>1 && v.getId()<respEscolhida.length()){
                respEscolhida = respEscolhida.substring(0,v.getId()-1) + " " + respEscolhida.substring(v.getId(),respEscolhida.length());
            }else if (v.getId() == respEscolhida.length()){
                respEscolhida = respEscolhida.substring(0,respEscolhida.length()-1);
                quantLetras--;
            }else if (respEscolhida.length() > 1){
                    respEscolhida = " " + respEscolhida.substring(v.getId(),respEscolhida.length());
            }else{
                respEscolhida="";
                quantLetras--;
            }
            return;
        }

        Button b = (Button) v;
        b.setVisibility(View.INVISIBLE);
        ImageView imageView;
        // Preenche campos vazios antes de seguir pros últimos campos
        boolean preencheVazio=false;
        if (quantLetras>0){
            for (int index=0;index<respEscolhida.length();index++){
                if (respEscolhida.substring(index,index+1).compareTo(" ")==0) {
                    respEscolhida = respEscolhida.substring(0,index) + b.getText() + respEscolhida.substring(index+1,respEscolhida.length());
                    preencheVazio=true;
                    imageView = (ImageView) findViewById(index+1);
                    //imageView.setBackgroundColor(R.color.blue_letters);
                    imageView.setImageURI(Uri.parse("android.resource://br.edu.ifspsaocarlos.sdm.trabalhofinal/drawable/letra"+ b.getText().toString().toLowerCase()));
                    break;
                }
            }
        }

        if (!preencheVazio){
            quantLetras++;
            imageView = (ImageView) findViewById(quantLetras);
            //imageView.setBackgroundColor(R.color.blue_letters);
            imageView.setImageURI(Uri.parse("android.resource://br.edu.ifspsaocarlos.sdm.trabalhofinal/drawable/letra"+ b.getText().toString().toLowerCase()));
            respEscolhida += b.getText();

        }

        if (quantLetras==tamanhoResp){
            if (respCerta.compareTo(respEscolhida)==0){
                Toast.makeText(getApplicationContext(), "Resposta Correta", Toast.LENGTH_SHORT).show();
                if (fase+1 < tamanhoBase){
                    Intent myIntent = new Intent(QuizDificil.this, QuizDificil.class);
                    myIntent.putExtra("fase", fase+1); //Optional parameters
                    QuizDificil.this.startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Você completou o jogo", Toast.LENGTH_SHORT).show();
                }
                finish();
            }else{
                //Busca o objeto de Texto
                Toast.makeText(getApplicationContext(), "Resposta errada! Tente Novamente", Toast.LENGTH_SHORT).show();
                for (int index=0;index<tamanhoResp;index++){
                    imageView = (ImageView) findViewById(index+1);
                    imageView.setImageResource(R.drawable.ic_semletra);
                    quantLetras=0;
                    respEscolhida="";
                }
                for (int index=0;index<10;index++){
                    Button button = mButtons.get(index);
                    button.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
