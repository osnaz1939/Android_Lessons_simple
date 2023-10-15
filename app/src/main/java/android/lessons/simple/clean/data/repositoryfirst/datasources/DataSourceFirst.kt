package android.lessons.simple.clean.data.repositoryfirst.datasources

class DataSourceFirst : IDataSource {
    override fun getNumber(): Int {
        return 10
    }
}