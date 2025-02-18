import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
    private LocalDate data;

    public Data(int dia, int mes, int ano) {
        this.data = LocalDate.of(ano, mes, dia);
    }

    public Data() {
        this.data = LocalDate.now();
    }

    public int getDia() {
        return data.getDayOfMonth();
    }

    public void setDia(int dia) {
        if (dataValida(data.getYear(), data.getMonthValue(), dia)) {
            this.data = LocalDate.of(data.getYear(), data.getMonthValue(), dia);
        } else {
            System.out.println("Dia inválido.");
        }
    }

    public int getMes() {
        return data.getMonthValue();
    }

    public void setMes(int mes) {
        if (dataValida(data.getYear(), mes, data.getDayOfMonth())) {
            this.data = LocalDate.of(data.getYear(), mes, data.getDayOfMonth());
        } else {
            System.out.println("Mês inválido ou dia incompatível.");
        }
    }

    public int getAno() {
        return data.getYear();
    }


    public void setAno(int ano) {
        if (dataValida(ano, data.getMonthValue(), data.getDayOfMonth())) {
            this.data = LocalDate.of(ano, data.getMonthValue(), data.getDayOfMonth());
        } else {
            System.out.println("Ano inválido para essa data.");
        }
    }

    private boolean dataValida(int ano, int mes, int dia) {
        try {
            LocalDate.of(ano, mes, dia);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public void avancarDia() {
        data = data.plusDays(1);
    }

    @Override
    public String toString() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static void main(String[] args) {
        Data data1 = new Data(28, 2, 2024);
        System.out.println("Data inicial: " + data1);
        data1.avancarDia();
        System.out.println("Dia seguinte: " + data1);

        Data dataAtual = new Data();
        System.out.println("Data atual: " + dataAtual);
        dataAtual.avancarDia();
        System.out.println("Data atual + um dia: " + dataAtual);
    }
}
