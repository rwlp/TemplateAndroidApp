package mypkg.templateandroid.utilities;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadFileUtils {

    public static String readJsonInAssetDir(Context context) {
        try {

            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(Constants.INITIALDATAFORRECYCLERVIEWHOMEJSON);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            reader.close();
            inputStreamReader.close();
            inputStream.close();

            // Return the JSON content as a string
            return stringBuilder.toString();
        } catch (IOException e) {
            // Handle exceptions, e.g., file not found or I/O error
            e.printStackTrace();
            return null;
        }
    }
}
