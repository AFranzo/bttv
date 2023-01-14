package bttv.api;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.StyleSpan;
import android.graphics.Color;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;

import bttv.Data;
import bttv.Res;
import bttv.ResUtil;
import bttv.settings.Settings;


public class DeletedMessages {

    public static Spanned reSpan(Spanned original) {
        if (!ResUtil.getBooleanFromSettings(Settings.ShowDeletedMessagesEnabled)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(original);
        String removedByModText = ResUtil.getLocaleString(Data.ctx, Res.strings.bttv_removed_by_mod);
        SpannableString postFix = new SpannableString("(" + removedByModText + ")");
        postFix.setSpan(new StyleSpan(Typeface.ITALIC), 0, postFix.length(), 0);
        spannableStringBuilder.setSpan(new StrikethroughSpan(),0,spannableStringBuilder.length(),0);
        spannableStringBuilder.append(postFix);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.GRAY),0,spannableStringBuilder.length(),0);

        return new SpannedString(spannableStringBuilder);
    }
}
