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

import android.content.res.ColorStateList;
import android.graphics.Color;

import androidx.core.content.ContextCompat;

import org.frap129.spectrum.Spectrum;

import com.grarak.kerneladiutor.R;
import com.grarak.kerneladiutor.fragments.DescriptionFragment;
import com.grarak.kerneladiutor.fragments.RecyclerViewFragment;
import com.grarak.kerneladiutor.utils.Prefs;
import com.grarak.kerneladiutor.views.recyclerview.CardView;
import com.grarak.kerneladiutor.views.recyclerview.DescriptionView;
import com.grarak.kerneladiutor.views.recyclerview.RecyclerViewItem;

import java.util.List;

/*
 * Based on the original implementation of Spectrum Kernel Manager by frap129 <joe@frap129.org>
 *
 * Originally authored by Morogoku <morogoku@hotmail.com>
 *
 * Modified by sunilpaulmathew <sunil.kde@gmail.com>
 */

public class SpectrumFragment extends RecyclerViewFragment {

    @Override
    protected void init() {
        super.init();

        addViewPagerFragment(DescriptionFragment.newInstance(getString(R.string.spec_title), getString(R.string.spec_info)));

    }

    private CardView oldCard;
    private DescriptionView oldDesc;

    @Override
    protected void addItems(List<RecyclerViewItem> items) {
		
        final int gam2Color = ContextCompat.getColor(getContext(), R.color.colorGaming2); //5
        final int gamColor = ContextCompat.getColor(getContext(), R.color.colorGaming); //3
        final int per2Color = ContextCompat.getColor(getContext(), R.color.colorPerformance2); //6
        final int perColor = ContextCompat.getColor(getContext(), R.color.colorPerformance); //1
	    final int bal2Color = ContextCompat.getColor(getContext(), R.color.colorBalance2); //4
        final int balColor = ContextCompat.getColor(getContext(), R.color.colorBalance); //0      
        final int batColor = ContextCompat.getColor(getContext(), R.color.colorBattery); //2
        final int bat2Color = ContextCompat.getColor(getContext(), R.color.colorBattery2); //7
        final int felColor = ContextCompat.getColor(getContext(), R.color.colorFelipeMode); //8
        final int noneColor = ContextCompat.getColor(getContext(), R.color.colorNone); //8
		
        //CardView Gaming2
        final CardView card5 = new CardView(getActivity());
        card5.setTitle(getString(R.string.spec_gaming2));
        card5.setExpandable(false);

        final DescriptionView desc5 = new DescriptionView();
        desc5.setSummary(getString(R.string.spec_gaming2_summary));
        desc5.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_game));

        card5.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card5, desc5, 5, gam2Color);
            }
        });

        card5.addItem(desc5);
        items.add(card5);
        //CardView Gaming2
		
        //CardView Gaming
        final CardView card3 = new CardView(getActivity());
        card3.setTitle(getString(R.string.spec_gaming));
        card3.setExpandable(false);

        final DescriptionView desc3 = new DescriptionView();
        desc3.setSummary(getString(R.string.spec_gaming_summary));
        desc3.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_game));

        card3.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card3, desc3, 3, gamColor);
            }
        });

        card3.addItem(desc3);
        items.add(card3);
        //CardView Gaming
		
        //CardView Performance2
        final CardView card6 = new CardView(getActivity());
        card6.setTitle(getString(R.string.spec_performance2));
        card6.setExpandable(false);

        final DescriptionView desc6 = new DescriptionView();
        desc6.setSummary(getString(R.string.spec_performance2_summary));
        desc6.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_performance));

        card6.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card6, desc6, 6, per2Color);
            }

        });	
		
        card6.addItem(desc6);
        items.add(card6);
        //CardView Performance2		
		
        //CardView Performance
        final CardView card1 = new CardView(getActivity());
        card1.setTitle(getString(R.string.spec_performance));
        card1.setExpandable(false);

        final DescriptionView desc1 = new DescriptionView();
        desc1.setSummary(getString(R.string.spec_performance_summary));
        desc1.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_performance));

        card1.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card1, desc1, 1, perColor);
            }

        });

        card1.addItem(desc1);
        items.add(card1);
        //CardView Performance
		
        //CardView Balanced2
        final CardView card4 = new CardView(getActivity());
        card4.setTitle(getString(R.string.spec_balanced2));
        card4.setExpandable(false);

        final DescriptionView desc4 = new DescriptionView();
        desc4.setSummary(getString(R.string.spec_balanced2_summary));
        desc4.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_balanced));

        card4.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card4, desc4, 4, bal2Color);
            }
        });

        card4.addItem(desc4);
        items.add(card4);
        //CardView Balanced2
		
        //CardView Balanced
        final CardView card0 = new CardView(getActivity());
        card0.setTitle(getString(R.string.spec_balanced));
        card0.setExpandable(false);

        final DescriptionView desc0 = new DescriptionView();
        desc0.setSummary(getString(R.string.spec_balanced_summary));
        desc0.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_balanced));

        card0.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card0, desc0, 0, balColor);
            }
        });

        card0.addItem(desc0);
        items.add(card0);
        //CardView Balanced
				
        //CardView Battery
        final CardView card2 = new CardView(getActivity());
        card2.setTitle(getString(R.string.spec_battery));
        card2.setExpandable(false);

        final DescriptionView desc2 = new DescriptionView();
        desc2.setSummary(getString(R.string.spec_battery_summary));
        desc2.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_battery));

        card2.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card2, desc2, 2, batColor);
            }

        });

        card2.addItem(desc2);
        items.add(card2);
        //CardView Battery
	
        //CardView Battery2
        final CardView card7 = new CardView(getActivity());
        card7.setTitle(getString(R.string.spec_battery2));
        card7.setExpandable(false);

        final DescriptionView desc7 = new DescriptionView();
        desc7.setSummary(getString(R.string.spec_battery2_summary));
        desc7.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_battery));

        card7.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card7, desc7, 7, bat2Color);
            }

        });

        card7.addItem(desc7);
        items.add(card7);
        //CardView Battery2

        //CardView FelipeMode
        final CardView card8 = new CardView(getActivity());
        card8.setTitle(getString(R.string.spec_felipe));
        card8.setExpandable(false);

        final DescriptionView desc8 = new DescriptionView();
        desc8.setSummary(getString(R.string.spec_felipe_summary));
        desc8.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_battery));

        card8.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card8, desc8, 8, felColor);
            }

        });

        card8.addItem(desc8);
        items.add(card8);
        //CardView FelipeMode
	
        //CardView None
        final CardView card9 = new CardView(getActivity());
        card9.setTitle(getString(R.string.spec_none));
        card9.setExpandable(false);

        final DescriptionView desc9 = new DescriptionView();
        desc9.setSummary(getString(R.string.spec_none_summary));
        desc9.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_spectrum_logo));

        card9.setOnItemClickListener(new CardView.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                cardClick(card9, desc9, 9, noneColor);
            }

        });

        card9.addItem(desc9);
        items.add(card9);
        //CardView None
		
        //Detects the selected profile on launch
        int mProfile = Prefs.getInt("spectrum_profile", 0, getActivity());

        if(mProfile == 0)
		{
            card0.GrxSetInitSelection(true, balColor);
            desc0.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card0;
            oldDesc = desc0;
        } 
		else if(mProfile == 1)
		{
            card1.GrxSetInitSelection(true, perColor);
            desc1.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card1;
            oldDesc = desc1;
        } 
		else if(mProfile == 2)
		{
            card2.GrxSetInitSelection(true, batColor);
            desc2.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card2;
            oldDesc = desc2;
        } 
		else if(mProfile == 3)
		{
            card3.GrxSetInitSelection(true, gamColor);
            desc3.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card3;
            oldDesc = desc3;
        }
		else if(mProfile == 4)
		{
            card4.GrxSetInitSelection(true, bal2Color);
            desc4.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card4;
            oldDesc = desc4;
        } 
		else if(mProfile == 5)
		{
            card5.GrxSetInitSelection(true, gam2Color);
            desc5.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card5;
            oldDesc = desc5;
        } 
		else if(mProfile == 6)
		{
            card6.GrxSetInitSelection(true, per2Color);
            desc6.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card6;
            oldDesc = desc6;
        }		
		else if(mProfile == 7)
		{
            card7.GrxSetInitSelection(true, bat2Color);
            desc7.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card7;
            oldDesc = desc7;
        }
		else if(mProfile == 8)
		{
            card8.GrxSetInitSelection(true, felColor);
            desc8.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card8;
            oldDesc = desc8;
        }
		else if(mProfile == 9)
		{
            card9.GrxSetInitSelection(true, noneColor);
            desc9.GrxSetInitSelection(true, Color.WHITE);
            oldCard = card9;
            oldDesc = desc9;
        }		
    }

    // Method that completes card onClick tasks
    private void cardClick(CardView card, DescriptionView desc, int prof, int color) {
        if (oldCard != card && oldDesc != desc) {
            ColorStateList ogColor = card.getCardBackgroundColor();
            ColorStateList odColor = desc.getTextColors();
            card.setCardBackgroundColor(color);
            desc.setTextColor(Color.WHITE);
            if(oldCard != null) oldCard.setCardBackgroundColor(ogColor);
            if(oldDesc != null) oldDesc.setTextColor(odColor);
            Spectrum.setProfile(prof);
            oldCard = card;
            oldDesc = desc;
            Prefs.saveInt("spectrum_profile", prof, getActivity());
        }
    }
}
