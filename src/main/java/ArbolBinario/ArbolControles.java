package ArbolBinario;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArbolControles extends JFrame {
    private Arbol arbol;
    private JPanel panelArbol;
    private JLabel resultadoRecorrido;
    private JPanel visualizacionPanel;
    private Timer fadeTimer;
    private float opacity = 0.0f;

    public ArbolControles(Arbol arbol) {
        this.arbol = arbol;
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Visualización del Árbol Binario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(245, 245, 245));
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 245));

        // Panel superior con título
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));
        JLabel titleLabel = new JLabel("Árbol Binario", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Panel de botones con diseño moderno
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        botonesPanel.setBackground(new Color(245, 245, 245));

        JButton btnPreorden = crearBotonEstilizado("Preorden", new Color(41, 128, 185));
        JButton btnInorden = crearBotonEstilizado("Inorden", new Color(46, 204, 113));
        JButton btnPostorden = crearBotonEstilizado("Postorden", new Color(52, 152, 219));

        botonesPanel.add(btnPreorden);
        botonesPanel.add(btnInorden);
        botonesPanel.add(btnPostorden);

        // Panel para la visualización con efecto fade
        visualizacionPanel = new JPanel(new BorderLayout());
        visualizacionPanel.setBackground(new Color(245, 245, 245));
        visualizacionPanel.setVisible(false);

        // Panel del árbol
        panelArbol = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                dibujarArbol(g2d, getWidth() / 2, 50, arbol.getRaiz(), getWidth() / 4);
            }
        };
        panelArbol.setBackground(new Color(245, 245, 245));
        panelArbol.setPreferredSize(new Dimension(750, 400));

        // Label para resultados con estilo moderno
        resultadoRecorrido = new JLabel("", SwingConstants.CENTER);
        resultadoRecorrido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultadoRecorrido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        resultadoRecorrido.setForeground(new Color(44, 62, 80));

        visualizacionPanel.add(panelArbol, BorderLayout.CENTER);
        visualizacionPanel.add(resultadoRecorrido, BorderLayout.SOUTH);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(botonesPanel, BorderLayout.CENTER);
        mainPanel.add(visualizacionPanel, BorderLayout.SOUTH);

        // Configurar el timer para la animación
        fadeTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.1f;
                if (opacity >= 1.0f) {
                    opacity = 1.0f;
                    fadeTimer.stop();
                }
                panelArbol.repaint();
            }
        });

        // Eventos de botones
        ActionListener buttonListener = e -> {
            if (!visualizacionPanel.isVisible()) {
                visualizacionPanel.setVisible(true);
                opacity = 0.0f;
                fadeTimer.start();
            }
            mostrarRecorrido(((JButton)e.getSource()).getText());
        };

        btnPreorden.addActionListener(buttonListener);
        btnInorden.addActionListener(buttonListener);
        btnPostorden.addActionListener(buttonListener);

        add(mainPanel);
    }

    private JButton crearBotonEstilizado(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setPreferredSize(new Dimension(120, 40));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(color.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(color);
            }
        });

        return boton;
    }

    private void dibujarArbol(Graphics2D g2d, int x, int y, Nodo nodo, int offset) {
        if (nodo != null) {
            int diametro = 40;

            // Dibujar conexiones primero (ramas)
            if (nodo.getSubarbolIzdo() != null || nodo.getSubarbolDcho() != null) {
                g2d.setStroke(new BasicStroke(2.0f));
                g2d.setColor(new Color(189, 195, 199));
            }

            if (nodo.getSubarbolIzdo() != null) {
                g2d.drawLine(x, y, x - offset, y + 70);
            }
            if (nodo.getSubarbolDcho() != null) {
                g2d.drawLine(x, y, x + offset, y + 70);
            }

            // Efecto de sombra
            g2d.setColor(new Color(0, 0, 0, 50));
            g2d.fill(new Ellipse2D.Double(x - diametro/2 + 2, y - diametro/2 + 2, diametro, diametro));

            // Dibujar nodo
            g2d.setColor(nodo == arbol.getRaiz() ? new Color(41, 128, 185) :
                    (nodo.getSubarbolIzdo() != null || nodo.getSubarbolDcho() != null) ?
                            new Color(46, 204, 113) : new Color(52, 152, 219));
            g2d.fill(new Ellipse2D.Double(x - diametro/2, y - diametro/2, diametro, diametro));

            // Dibujar valor
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Segoe UI", Font.BOLD, 16));
            String valor = String.valueOf(nodo.valorNodo());
            FontMetrics fm = g2d.getFontMetrics();
            g2d.drawString(valor, x - fm.stringWidth(valor)/2, y + fm.getHeight()/4);

            // Dibujar subárboles recursivamente
            if (nodo.getSubarbolIzdo() != null) {
                dibujarArbol(g2d, x - offset, y + 70, nodo.getSubarbolIzdo(), offset / 2);
            }
            if (nodo.getSubarbolDcho() != null) {
                dibujarArbol(g2d, x + offset, y + 70, nodo.getSubarbolDcho(), offset / 2);
            }
        }
    }

    private void mostrarRecorrido(String tipo) {
        StringBuilder resultado = new StringBuilder();
        switch (tipo) {
            case "Preorden":
                resultado.append("Recorrido en Preorden: ");
                capturarRecorrido(arbol.getRaiz(), resultado, "pre");
                break;
            case "Inorden":
                resultado.append("Recorrido en Inorden: ");
                capturarRecorrido(arbol.getRaiz(), resultado, "in");
                break;
            case "Postorden":
                resultado.append("Recorrido en Postorden: ");
                capturarRecorrido(arbol.getRaiz(), resultado, "post");
                break;
        }
        resultadoRecorrido.setText(resultado.toString());
    }

    private void capturarRecorrido(Nodo nodo, StringBuilder sb, String tipo) {
        if (nodo != null) {
            switch (tipo) {
                case "pre":
                    sb.append(nodo.valorNodo()).append(" ");
                    capturarRecorrido(nodo.getSubarbolIzdo(), sb, tipo);
                    capturarRecorrido(nodo.getSubarbolDcho(), sb, tipo);
                    break;
                case "in":
                    capturarRecorrido(nodo.getSubarbolIzdo(), sb, tipo);
                    sb.append(nodo.valorNodo()).append(" ");
                    capturarRecorrido(nodo.getSubarbolDcho(), sb, tipo);
                    break;
                case "post":
                    capturarRecorrido(nodo.getSubarbolIzdo(), sb, tipo);
                    capturarRecorrido(nodo.getSubarbolDcho(), sb, tipo);
                    sb.append(nodo.valorNodo()).append(" ");
                    break;
            }
        }
    }
}