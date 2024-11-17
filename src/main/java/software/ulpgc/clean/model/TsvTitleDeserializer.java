package software.ulpgc.clean.model;

import java.util.Arrays;
import java.util.List;

public class TsvTitleDeserializer implements TitleDeserializer{
    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }
    private Title deserialize(String[] split) {
        return new Title(
                split[3],
                split[8].equals("\\N") ? List.of() : Arrays.asList(split[8].split(","))
        );
    }
}
