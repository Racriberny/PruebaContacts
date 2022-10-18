package com.example.pruebacontacts;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

    public class ContactParser {
        private Contacto[] contactos;
        private final InputStream contactsFile;
        public ContactParser(Context c) {
            this.contactsFile = c.getResources().openRawResource(R.raw.contacts);
        }

        public boolean parse() {
            boolean parsed = false;
            String json ;
            contactos = null;
            try {
                int size = contactsFile.available();
                byte[] buffer = new byte[size];
                contactsFile.read(buffer);
                contactsFile.close();
                json = new String(buffer, "UTF-8");
                JSONTokener tokener = new JSONTokener(json);
                JSONArray jsonArray = new JSONArray(tokener);
                contactos = new Contacto[jsonArray.length()];
                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    String firstSurname = jsonObject.getString("firstSurname");
                    String secondSurname = jsonObject.getString("secondSurname");
                    String photo = jsonObject.getString("photo");
                    String birth = jsonObject.getString("birth");
                    String company = jsonObject.getString("company");
                    String email = jsonObject.getString("email");
                    String phone1 = jsonObject.getString("phone1");
                    String phone2 = jsonObject.getString("phone2");
                    String address = jsonObject.getString("address");
                    contactos[i] = new Contacto(id, name, firstSurname, secondSurname, photo, birth, company, email, phone1, phone2, address);
                }

                parsed = true;
            } catch (Exception e) {
                Log.e("CountryParser", "Unknown Exception: "+e.getLocalizedMessage());
            }
            return parsed;
        }

        public Contacto[] getContactos() {

            return this.contactos;
        }

    }
