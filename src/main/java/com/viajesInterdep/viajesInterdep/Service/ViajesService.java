package com.viajesInterdep.viajesInterdep.Service;

import com.viajesInterdep.viajesInterdep.Clases.Viajes;
import com.viajesInterdep.viajesInterdep.Repository.ViajesRepository;
import javassist.NotFoundException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Service
public class ViajesService {

    @Autowired
    ViajesRepository viajesRepository;

    private static Path filePath = null; //= "C:\\Users\\esteb\\Downloads\\viajesInterdep\\src\\main\\resources\\Viajes.Json";
    String jsonString = "";

    public String crearViajes() throws NotFoundException {
        try {
            filePath = Path.of("C:\\Users\\esteb\\Downloads\\viajesInterdep\\src\\main\\resources\\Viajes.Json");
            //Leo archivo
            jsonString = Files.readString(filePath);
            System.out.println(jsonString);

            JSONObject obj = new JSONObject(jsonString);

            List<Viajes> list = new ArrayList<Viajes>();
            JSONArray array = obj.getJSONArray("viajes");

            Viajes viajeAux = new Viajes();
            for (int i = 0; i < array.length(); i++) {
                String partida = (array.getJSONObject(i).getString("partida"));
                String destino = (array.getJSONObject(i).getString("destino"));
                Long asientosTotales = (array.getJSONObject(i).getLong("asientosTotales"));
                Short diaSemana = (Short.parseShort(array.getJSONObject(i).getString("diaSemana")));
                Time hora = (java.sql.Time.valueOf(array.getJSONObject(i).getString("hora")));
                Viajes viaje = new Viajes(partida, destino, asientosTotales, diaSemana, hora);
                System.out.println("viaje queda: " + viaje.toString());
                viajesRepository.save(viaje);
            }

            return "Ventas creadas correctamente";

        } catch (JSONException | IOException e) {
            return "Error creando viaje, " + e + jsonString;
        }
    }
}
