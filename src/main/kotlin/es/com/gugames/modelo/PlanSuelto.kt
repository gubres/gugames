package es.com.gugames.modelo


class PlanSuelto(
    tipo: String,
    id: Int = 0): Plan (tipo, id) {

    override fun obtenerValor(alquiler: Alquiler): Double {
        var valorOriginal = super.obtenerValor(alquiler)
        if (alquiler.gamer.media > 8) {
            valorOriginal -= valorOriginal * 0.1
        }
        return valorOriginal
    }

    override fun toString(): String {
        return "Plan Suelto\n" +
                "Tipo: $tipo \n" +
                "Id: $id \n"
    }
}
