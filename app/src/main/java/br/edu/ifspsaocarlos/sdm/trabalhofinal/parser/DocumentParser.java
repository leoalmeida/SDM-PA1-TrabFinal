package br.edu.ifspsaocarlos.sdm.trabalhofinal.parser;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.model.Document;

/**
 * Created by Leonardo on 29/09/13.
 */
public class DocumentParser {
    public String toJSON(List<Document> Documentos){

        try{
            JSONStringer jsonStringer = new JSONStringer();
            jsonStringer.object().key("list").array().object().key("document").array();

            for (Document documento : Documentos){
                jsonStringer.object()
                        .key("id").value(documento.getId())
                        .key("titulo").value(documento.getTitulo())
                        .key("owner").value(documento.getOwner())
                        .key("detalhe").value(documento.getDetalhe())
                        .key("data").value(documento.getData())
                        .key("thumb_url").value(documento.getThumb_url())
                        .key("link").value(documento.getLink())
                        .endObject();
            }
            return jsonStringer.endArray().endObject().endArray().endObject().toString();
        }catch (JSONException e ){
            Log.e("JSON","@string/msg_json");
            Log.e("JSON",e.toString());
        }
        return "";
    }
}
