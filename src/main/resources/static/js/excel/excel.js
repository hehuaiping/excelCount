var vm;
$(function(){
    vm = new Vue({
        el: '#app',
        data: {
            fileList:[]
        },
        methods:{
            exportExcel() {
                console.log('导出数据');
            }
            ,
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file);
            },
            handleExceed(files, fileList) {
                this.$message.warning(`当前限制选择文件个数，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
            },
            beforeRemove(file, fileList) {
                return this.$confirm(`确定移除 ${ file.name }？`);
            }
        },
        mounted:function () {
        }
    });

});