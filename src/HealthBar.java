import java.io.File;

import acm.graphics.GCompound;
import acm.graphics.GImage;

public class HealthBar extends GCompound {
	GImage sprite_still;
	public HealthBar(){
		
		File file = new File("../bin/health.png");

			
			String fileName = file.getPath();
			 sprite_still = new GImage(fileName);
			this.add(sprite_still);
	}

}
