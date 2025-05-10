package raltsmc.desolation.init.helpers;

import com.terraformersmc.terraform.boat.api.data.TerraformBoatDfuApi;

import java.util.Collection;
import java.util.Set;

public class DesolationBoatDfu implements TerraformBoatDfuApi {
    @Override
    public Collection<String> getDfuBoatIds() {
        return Set.of("desolation:charred_boat", "desolation:charred_chest_boat");
    }
}
