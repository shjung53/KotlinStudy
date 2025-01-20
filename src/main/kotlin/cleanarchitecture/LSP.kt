package cleanarchitecture

open class Rectangle {
    private var height: Int = 0
    private var width: Int = 0

    open fun setHeight(height: Int) {
        this.height = height
    }

    open fun setWidth(width: Int) {
        this.width = width
    }

    fun getSize(): Int = width * height
}

class Square : Rectangle() {
    override fun setHeight(height: Int) {
        super.setHeight(height)
        super.setWidth(height)
    }

    override fun setWidth(width: Int) {
        super.setWidth(width)
        super.setHeight(width)
    }
}

fun main() {
    val rectangle: Rectangle = Square()
    rectangle.setHeight(3)
    rectangle.setWidth(5)
    println(rectangle.getSize())
}
