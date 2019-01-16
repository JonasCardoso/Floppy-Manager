/*
 * Copyright (C) 2018-2019 sunilpaulmathew <sunil.kde@gmail.com>
 *
 * This file is part of SmartPack Kernel Manager, which is a heavily modified version of Kernel Adiutor,
 * originally developed by Willi Ye <williye97@gmail.com>
 *
 * Both SmartPack Kernel Manager & Kernel Adiutor are free softwares: you can redistribute it 
 * and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SmartPack Kernel Manager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SmartPack Kernel Manager.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.frap129.spectrum;

import android.annotation.TargetApi;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import com.grarak.kerneladiutor.R;
import com.grarak.kerneladiutor.utils.Prefs;
import com.grarak.kerneladiutor.utils.Utils;

/*
 * Based on the original implementation of Spectrum Kernel Manager by frap129 <joe@frap129.org>
 *
 * Originally authored by Morogoku <morogoku@hotmail.com>
 *
 * Modified by sunilpaulmathew <sunil.kde@gmail.com>
 */

@TargetApi(Build.VERSION_CODES.N)
public class ProfileTile extends TileService {

    private static final String SERVICE_STATUS_FLAG = "serviceStatus";
    private int id = 0;
    @Override
    public void onStartListening() {
        resetTileStatus();
    }

    @Override
    public void onClick() {
        updateTile();
    }

    private void updateTile() {
        Tile tile = this.getQsTile();
        boolean isActive = getServiceStatus();
        Icon newIcon;
        String newLabel;
        int newState;

        // Update tile and set profile
        if (!(Spectrum.supported_root() || !Spectrum.supported_init())) {
            newLabel = "No Spectrum support";
            newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_logo);
            newState = Tile.STATE_INACTIVE;
        }
		else 
		{
            if (id == 9) 
			{
				newLabel = "Gates of Hell";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_game);
				newState = Tile.STATE_ACTIVE;
				id = 0;
				Spectrum.setProfile(5);
				Prefs.saveInt("spectrum_profile", 5, getApplicationContext());
            } 
			else if (id == 8) 
			{
				newLabel = "Gaming";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_game);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(3);
				Prefs.saveInt("spectrum_profile", 3, getApplicationContext());

            } 
			else if (id == 7) 
			{
				newLabel = "Performance Plus";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_game);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(6);
				Prefs.saveInt("spectrum_profile", 6, getApplicationContext());

            }			
			else if (id == 6) 
			{
                newLabel = "Performance";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_performance);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(1);
				Prefs.saveInt("spectrum_profile", 1, getApplicationContext());

            } 
			else if (id == 5) 
			{
				newLabel = "Balance Smooth";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_balanced);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(4);
				Prefs.saveInt("spectrum_profile", 4, getApplicationContext());
            } 
			else if (id == 4) 
			{
				newLabel = "Balance Battery";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_balanced);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(0);
				Prefs.saveInt("spectrum_profile", 0, getApplicationContext());
            }
			else if (id == 3) 
			{
				newLabel = "Battery";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_battery);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(2);
				Prefs.saveInt("spectrum_profile", 2, getApplicationContext());
            }			
			else if (id == 2) 
			{
				newLabel = "Ultra Battery";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_battery);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(7);
				Prefs.saveInt("spectrum_profile", 7, getApplicationContext());
            }
			else if (id == 1) 
			{
				newLabel = "Felipe Mode";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_battery);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(8);
				Prefs.saveInt("spectrum_profile", 8, getApplicationContext());
            }
			else
			{
				newLabel = "None";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_logo);
				newState = Tile.STATE_ACTIVE;
				id +=1;
				Spectrum.setProfile(9);
				Prefs.saveInt("spectrum_profile", 9, getApplicationContext());
            }
        }

        // Change the UI of the tile.
        tile.setLabel(newLabel);
        tile.setIcon(newIcon);
        tile.setState(newState);
        tile.updateTile();
    }

    private boolean getServiceStatus() {

        boolean isActive = Prefs.getBoolean(SERVICE_STATUS_FLAG, false, getApplicationContext());
        isActive = !isActive;

        Prefs.saveBoolean(SERVICE_STATUS_FLAG, isActive, getApplicationContext());

        return isActive;
    }

    private void resetTileStatus() {
        int profile = Utils.strToInt(Spectrum.getProfile());
        Tile tile = this.getQsTile();
        Icon newIcon;
        String newLabel;
        int newState;

        // Update tile
        if (!(Spectrum.supported_root() || !Spectrum.supported_init())) 
		{
            newLabel = "No Spectrum support";
            newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_logo);
            newState = Tile.STATE_INACTIVE;
        }
		else 
		{
            if (profile == 5)
			{
				newLabel = "Gates of Hell";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_game);
				newState = Tile.STATE_ACTIVE;
            } 
			else if (profile == 3)
			{
				newLabel = "Gaming";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_game);
				newState = Tile.STATE_ACTIVE;

            } 
			else if (profile == 4)
			{
				newLabel = "Performance Plus";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_performance);
				newState = Tile.STATE_ACTIVE;

            } 
			else if (profile == 1)
			{
				newLabel = "Performance";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_performance);
				newState = Tile.STATE_ACTIVE;

            } 
			else if (profile == 4)
			{
				newLabel = "Balance Smooth";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_balanced);
				newState = Tile.STATE_ACTIVE;
            } 
			else if (profile == 0)
			{
				newLabel = "Balance Battery";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_balanced);
				newState = Tile.STATE_ACTIVE;
            } 
			else if (profile == 2)
			{
				newLabel = "Battery";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_battery);
				newState = Tile.STATE_ACTIVE;
            }
			else if (profile == 7)
			{
				newLabel = "Ultra Battery";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_battery);
				newState = Tile.STATE_ACTIVE;
            }
			else if (profile == 8)
			{
				newLabel = "Felipe Mode";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_battery);
				newState = Tile.STATE_ACTIVE;
            } 
			else
			{
				newLabel = "None";
				newIcon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_spectrum_logo);
				newState = Tile.STATE_ACTIVE;
            }			
        }

        // Change the UI of the tile.
        tile.setLabel(newLabel);
        tile.setIcon(newIcon);
        tile.setState(newState);
        tile.updateTile();
    }
}
