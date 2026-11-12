package com.guiaia.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends Activity {
    static final int FONDO = 0xFF050E24, TARJETA = 0xFF0B1B3F, ACENTO = 0xFF1EA7FF,
            TEXTO = 0xFFFFFFFF, SUAVE = 0xFF9FB4D8;
    LinearLayout lista;
    String categoriaActual = "Todas";
    LinearLayout fila;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        getWindow().setStatusBarColor(FONDO);
        getWindow().setNavigationBarColor(FONDO);
        mostrarBienvenida();
    }

    int dp(int v) { return Math.round(v * getResources().getDisplayMetrics().density); }

    GradientDrawable caja(int color, int radio, int borde) {
        GradientDrawable g = new GradientDrawable();
        g.setColor(color); g.setCornerRadius(dp(radio));
        if (borde != 0) g.setStroke(dp(1), borde);
        return g;
    }

    TextView texto(String s, int sp, int color, boolean negrita) {
        TextView t = new TextView(this);
        t.setText(s); t.setTextSize(sp); t.setTextColor(color);
        if (negrita) t.setTypeface(Typeface.DEFAULT_BOLD);
        return t;
    }

    void mostrarBienvenida() {
        LinearLayout r = new LinearLayout(this);
        r.setOrientation(LinearLayout.VERTICAL);
        r.setBackgroundColor(FONDO);
        r.setPadding(dp(16), dp(32), dp(16), dp(24));
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.bienvenida_libro);
        img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r.addView(img, new LinearLayout.LayoutParams(-1, 0, 1f));
        Button btn = new Button(this);
        btn.setText("Entrar a la guía");
        btn.setTextColor(Color.WHITE); btn.setAllCaps(false); btn.setTextSize(17);
        btn.setBackground(caja(ACENTO, 28, 0));
        btn.setOnClickListener(v -> mostrarPrincipal());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, dp(56));
        lp.topMargin = dp(16);
        r.addView(btn, lp);
        setContentView(r);
    }

    void mostrarPrincipal() {
        LinearLayout r = new LinearLayout(this);
        r.setOrientation(LinearLayout.VERTICAL);
        r.setBackgroundColor(FONDO);
        r.setPadding(dp(16), dp(36), dp(16), 0);

        TextView t = texto(Contenido.TITULO, 22, TEXTO, true);
        r.addView(t);
        TextView s = texto(Contenido.SUBTITULO, 13, SUAVE, false);
        s.setPadding(0, dp(6), 0, dp(12));
        r.addView(s);

        HorizontalScrollView hs = new HorizontalScrollView(this);
        hs.setHorizontalScrollBarEnabled(false);
        fila = new LinearLayout(this);
        fila.setOrientation(LinearLayout.HORIZONTAL);
        hs.addView(fila);
        r.addView(hs);

        ScrollView sv = new ScrollView(this);
        lista = new LinearLayout(this);
        lista.setOrientation(LinearLayout.VERTICAL);
        lista.setPadding(0, dp(12), 0, dp(24));
        sv.addView(lista);
        r.addView(sv, new LinearLayout.LayoutParams(-1, 0, 1f));
        setContentView(r);
        refrescar();
    }

    void refrescar() {
        fila.removeAllViews();
        for (String c : Contenido.CATEGORIAS) {
            boolean sel = c.equals(categoriaActual);
            TextView chip = texto(c, 14, sel ? Color.WHITE : SUAVE, sel);
            chip.setPadding(dp(16), dp(8), dp(16), dp(8));
            chip.setBackground(caja(sel ? ACENTO : TARJETA, 20, sel ? ACENTO : 0x553A6BB5));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
            lp.rightMargin = dp(8);
            chip.setOnClickListener(v -> { categoriaActual = c; refrescar(); });
            fila.addView(chip, lp);
        }
        lista.removeAllViews();
        for (String[] h : Contenido.HERRAMIENTAS) {
            if (!categoriaActual.equals("Todas") && !categoriaActual.equals(h[0])) continue;
            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(dp(16), dp(14), dp(16), dp(14));
            card.setBackground(caja(TARJETA, 16, 0x663A6BB5));
            card.addView(texto(h[0].toUpperCase(), 11, ACENTO, true));
            TextView n = texto(h[1], 19, TEXTO, true);
            n.setPadding(0, dp(2), 0, dp(4));
            card.addView(n);
            card.addView(texto(h[2], 14, SUAVE, false));
            TextView ab = texto("Abrir sitio  ›", 14, ACENTO, true);
            ab.setPadding(0, dp(10), 0, 0);
            card.addView(ab);
            final String url = h[3];
            card.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url))));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            lp.bottomMargin = dp(12);
            lista.addView(card, lp);
        }
    }
}
