var vm;
$(function(){
    vm = new Vue({
        el: '#app',
        data: {
            fileList:[]
        },
        methods:{
            exportExcel() {
                window.open("/exportExcel")
                //window.location.href = "/exportExcel";
            },
            clean() {
                $.ajax({
                    type: "GET",
                    url: "/upload/clearData",
                    contentType: "application/json",
                    success: function(r){
                        vm.fileList = [];
                        alert(r);
                    }
                });
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