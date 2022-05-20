import request from '/@/utils/request'
// 分页
export function findByPage(params:object){
    return request({
        url: '/admin/driver/info',
        method: 'get',
        params: params
    })

}
// 通过id查询司机信息
export function getDriverById(params:object){
    return  request({
        url:"/admin/driver/getById",
        method:'get',
        params:params
    })
}
// 更新司机信息
export function updateDriver(params:Object){
  return  request ({
        url: '/admin/driver/update',
        method:"put",
        data:params
    })
}
// 添加司机
export function addDriver(params:Object){
    return request({
        url:'/admin/driver/add',
        method:'post',
        data:params
    })
}
    // 删除司机，通过id删除
    export function deleteDriver(params:object){
            return request({
                url:'/admin/driver/del',
                method:'delete',
                params:params
            })
    }
