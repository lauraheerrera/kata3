package software.ulpgc.clean.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTitleLoader implements TitleLoader{
    private final File file;
    private final TitleDeserializer deserializer;

    public FileTitleLoader(File file, TitleDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }
 
    @Override
    public List<Title> load() throws IOException {
        ArrayList<Title> titles = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            bufferedReader.readLine();
            while (true){
                String line = bufferedReader.readLine();
                if(line == null) break;
                titles.add(deserializer.deserialize(line));
            }
        }
        return titles;
    }
}


