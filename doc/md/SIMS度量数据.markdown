# 企业进销存系统 SIMS(Sales Invoicing Management System)

# 度量数据

# 草稿

## plsw软工二小组

## 2017-9-27

## 更新历史

| **修改人员** | **日期** | **变更原因** | **版本号** |
| --- | --- | --- | --- |
| 王灿灿 | 2017-10-2 | 整合文档 | V1.0 草稿 |
| 王灿灿 | 2018-1-13 | 修改文档 | V2.0 |

总功能点数为：935.25

##**财务人员度量数据**

用例数量：3

平均每个用例的场景数：9

平均用例行数：200

功能需求数量：35

输入：13

输出：20

查询：6

逻辑文件：10

对外接口：0

| 编号 | 需求描述与度量 |
| --- | --- |
|BAM.Edit|财务人员（最高权限）能在modify情况下修改账户名称（其余属性不可修改）|
| BAM.CheckID | 财务人员（最高权限）请求管理账户时，系统检测登录者的ID和权限，若满足则允许并开放，否则提示没有权限 |
|BAM.Find|财务人员（最高权限）通过关键字查找账户（输入），系统返回待选择账户列表（逻辑文件，输出）|
|BAM.Select.Document|财务人员（最高权限）通过勾选选中账户，系统显示被勾选|
|BAM.Cancel|财务人员（最高权限）需要取消增删改的操作（输入），系统退出当前操作（不保存）|
|BAM.Confirm|财务人员（最高权限）需要保存（输入）执行的操作时，系统返回确认信息（输出），确认（输入）完成后系统保存操作|
|BAM.Check|财务人员（最高权限）请求查看账户信息（输入），系统返回账户详细信息（逻辑文件，输出）|
|BAM.New|财务人员（最高权限）请求新增（输入）一个账户，系统返回待修改的基础账户模板（逻辑文件，输出），只有选择确认系统才会保存新建账户|
|BAM.Del|财务人员（最高权限）请求删除账户（输入），系统返回确认信息（输出），只有选择确认（输入）才能将账户删除|
|BAM.Modify|财务人员（最高权限）请求修改（输入）账户，系统返回账户名称（逻辑文件，输出），只有选择确认（输入）系统才会保存修改信息|
|BAM.Close.Exit|退出账户管理|
|BAM.ErrorPermission|该人员试图无权限操作（输入），系统提示权限不足（输出）|
|BAM.ErrorName|输入非法的账户名称，系统提示账户名非法|
|BAM.Succeed|财务人员增删改操作正确并确认后，系统返回操作成功|
|MFD.Close.Exit|退出制定财务类单据|
|MFD.Confirm|财务人员需要保存（输入）执行的操作时，系统返回确认信息（输出），确认（输入）完成后系统保存操作|
|MFD.Cancel|财务人员取消操作（输入），系统退出当前执行的操作（不保存）|
|MFD.Select.Document|财务人员选中单据|
|MFD.Edit|系统允许财务人员编辑草稿状态下除单据编号、操作员以外的信息|
|MFD.Print|财务人员选择打印（输入）单据后，系统打印单据（输出）|
| MFD.Select.DocumentType |财务人员选择收款单或付款单（输出），系统返回该类型单据的四种状态（逻辑文件）（输出）|
|MFD.Select.DocumentState|财务人员选择要查看单据的类型（输入），系统返回对应状态的单据列表（逻辑文件，输出）|
|MFD.New|财务人员新建（输入）草稿状态的收款单（付款单），系统返回待完成的初始单据信息，只有选择确认系统才会保存新建|
|MFD.Modify|财务人员请求修改（输入）草稿状态的单据，系统返回待修改单据信息（逻辑文件，输出），只有选择确认系统才会保存修改|
|MFD.Del|财务人员请求删除（输入）草稿状态的单据，系统返回确认信息（输出），只有选择确认（输入）系统才会删除单据|
|MFD.Check|财务人员选择查看被选中单据（输入），系统返回被选中单据的信息（逻辑文件，输出）|
|MFD.Sub|财务人员提交草稿状态的单据，系统返回确认信息，只有选择确认系统才会将单据提交（输出）至总经理，并将单据信息修改为待审批|
|MFD.Compelet|财务人员选择将待完成状态的单据完成（输入），系统返回确认信息，只有选择确认系统才会将单据状态修改为完成|
|MFD.Succeed|财务人员增、删、改、提交等操作正确并确认后，系统返回操作成功|
|SetUp.Close.Edit|财务人员退出期初建账|
|SetUp.Edit|财务人员仅可以对正在新建的账簿信息进行修改|
|SetUp.Confirm |财务人员需要保存（输入）执行的操作时，系统返回确认信息，确认完成后系统保存操作|
|SetUp.Cancel|财务人员取消操作（输入），系统退出当前执行的操作（不保存）|
|SetUp.Select.Books|财务人员选中账簿|
|SetUp.New|财务人员选择建立新的账簿（输入），系统提供账簿的初始信息（逻辑文件，输出）|
|SetUp.Check|财务人员选择并查看账簿（输入），系统返回被选中账簿的信息（逻辑文件，输出）（不可修改）|
|SetUp.Delete|财务人员选中并删除账簿（输入），系统返回确认信息（输出），财务人员确认（输入）后系统删除账簿并提示删除成功|
|SetUp.Succeed|财务人员增、删操作正确并确认后，系统返回操作成功|

进销存系统属于中等系统，所以其功能点测度总数=13\*4 + 20\*5 + 6\*4 + 10\*10 + 0\*7= 276

系统的复杂度因子为40

功能点：

   FP =276 \* (0.65 + 0.01 \* 40) = 289.5

##**总经理度量数据**

用例数量：2

平均每个用例的场景数：12

平均用例行数：200

功能需求数量：35

输入：1

输出：15

查询：12

逻辑文件：7

对外接口：0

| 编号 | 需求描述与度量 |
| --- | --- |
| Catalog.Cancle | 在总经理请求取消商品调整任务时，系统关闭商品调整任务 |
| Catalog.New | 在总经理输入商品标识时，系统将该新商品加入商品目录 |
| Catalog.Del | 在总经理请求删除商品目录中一个商品时，系统在商品列表中将该商品标记为&quot;已移除&quot; |
| Catalog.Confirm | 在总经理确认商品调整任务结束时，系统更新数据，关闭商品调整任务 |
| Promotion.Select | 在总经理请求制定一个促销策略类型时，系统显示该类型的促销策略列表 |
| Promotion.New | 在总经理请求增加新的促销策略时，系统在促销策略列表中增加新的促销策略，并标记为&quot;New&quot;状态 |
| Promotion.Del. | 在总经理请求删除已有的促销策略时，系统在促销策略列表中移除指定的促销策略 |
| Promotion.Edit | 系统应该允许总经理编辑列表中状态为&quot;New&quot;状态的促销策略 |
| Promotion.Cancle | 在总经理请求取消促销策略定制时，系统应该关闭定制促销策略服务 |
| Promotion.Confirm | 系统应该允许总经理确认制定促销策略结束 |
| Promotion.Confirm.Invalid | 在促销列表中&quot;New&quot;状态策略数据没有全部通过检查时，系统提示有促销策略数据不完整或不正确 |
| Promotion.Confirm.Valid | 在促销列表中所有&quot;New&quot;状态策略数据都通过检查时，系统更新数据，关闭促销策略制定任务 |
| Promotion.Valid | 系统应该验证每个促销策略的数据完整性和一致性 |
| Promotion.Valid.StartDate | 在促销策略的开始日期为空或者开始日期晚于等于当天60天时，系统提示开始日期不正确，验证不通过 |
| Promotion.Valid.EndDate | 在促销策略的结束日期为空或者结束日期早于等于当天时，系统提示结束日期不正确，验证不通过 |
| Promotion.Valid.GoodsGift | 在商品赠送策略的促销商品标识或赠品标识不在商品目录中时，系统提示促销商品标识或赠品标识不正确，验证不通过 |
| Promotion.Valid.GoodsDiscount | 在商品特价策略的促销商品标识不在商品目录中或者特价为空或者特价&lt;=0或者特价&gt;=价格时，系统提示商品标识或者特价不正确，验证不通过 |
| Promotion.Valid. AmountGift | 在总额特价策略的额度&lt;=30或者赠品标识不在商品目录中时，系统提示额度或赠品标识不正确，验证不通过 |
| Promotion.Valid. AmountDiscount | 在总额特价策略的额度&lt;=30或者折扣率&lt;=0或者折扣率&gt;=1时，系统提示额度或折扣率不正确，验证不通过 |
| Promotion.Valid.Redundancy | 在促销策略存在重复时（参见BR11-14），系统提示存在重复，验证不通过 |
| Promotion.Update | 系统更新重要数据，整个更新过程组成一个事务，要么全部更新，要么全部不更新 |
| Promotion.Update.GoodsGift | 系统更新商品赠送策略 |
| Promotion.Update.GoodsDiscount | 系统更新商品特价策略 |
| Promotion.Update.AmountGift | 系统更新总额赠送策略 |
| Promotion.Update.AmountDiscount | 系统更新总额特价策略 |

进销存系统属于中等系统，所以其功能点测度总数=1\*4 + 15\*5 + 12\*4 + 7\*10 + 0\*7= 194

系统的复杂度因子为40

功能点：

   FP =194 \* (0.65 + 0.01 \* 40) = 203.7

##**库存管理人员度量数据**

用例数量：5

平均每个用例的场景数：8

平均用例行数：200

功能需求数量：35

输入：1

输出：15

查询：12

逻辑文件：7

对外接口：0

| 编号 | 需求描述与度量 |
| --- | --- |
Classify.New.Show|在库存管理人员请求（查询）增加分类时，系统生成一个分类编号，并在分类列表中增加该新分类的显示（输出）|
Classify.New.Exist|在库存管理人员增加相同的分类（逻辑文件）时，系统会显示&quot;已存在该分类&quot;并拒绝输入（输出）|
Classify.Del|在库存管理人员请求删除分类列表中一个分类时，系统在分类列表中将该分类标记为&quot;已移除&quot;（输出）|
Classify.Edit.Show|在库存管理人员成功完成修改分类操作后（查询），系统提示&quot;已修改&quot;（输出）|
Classify.Edit.Name|库存管理人员在修改分类时只能进行分类名称的修改，若修改具体商品的分类，只能在商品管理中修改商品属性|
Classify.Edit.Repeat|在库存管理人员输入与之前相同的分类时，系统提示&quot;重复修改&quot;（逻辑文件）并拒绝输入（输出） |
Classify.Invalid | 在库存管理人员输入不存在的分类或者不符合规范的编号时，系统提示输入无效（输出） |
Classify.Record  | 在库存管理人员结束本次分类管理操作时，系统需记录本次操作的时间以及具体操作记录（逻辑文件） |
Classify.Confirm|在增删改操作中需点击确认操作保存此次操作（查询）|
Classify.Cancel |在商品分类管理操作中可取消任一增删改任务，系统会退出（查询） |
Classify.Close.Exit | 系统关闭本次商品分类管理任务 |
Merchandise.Invalid | 在库存管理人员输入不存在或者不符合规范的商品编号时，系统提示输入无效（输出） |
Merchandise.New.Show|在库存管理人员请求（查询）增加商品时，系统生成一个新商品编号，并在商品列表中增加该新商品的显示（输出）|
Merchandise.New.Exist|在库存管理人员增加已存在（逻辑文件）的商品时，系统提示&quot;已存在&quot;并拒绝输入（输出）|
Merchandise.Del|在库存管理人员请求（查询）删除商品列表中一个商品时，系统在商品列表中将该商品标记为&quot;已移除&quot;（输出）|
Merchandise.Edit.Show|在库存管理人员请求（查询）修改商品信息时，但确认完之后会有&quot;已修改&quot;的提示（输出）|
Merchandise.Edit.Repeat|在库存管理人员修改成原来的商品信息（逻辑文件）时，系统提示&quot;重复修改&quot;并拒绝输入（输出）|  Merchandise.Edit.Others|系统应该允许库存管理人员编辑商品列表中除商品编号之外的数据（输入） |
Merchandise.Record | 在库存管理人员结束本次商品管理操作时，系统需记录本次操作的时间以及具体操作记录 |
Merchandise.Confirm|在增删改操作中需点击确认操作保存此次操作（查询）|
Merchandise.Cancel|在商品管理操作中可取消任一增删改任务，系统会退出（查询） |
Merchandise.Close.Exit | 系统关闭本次商品管理任务 |
Check.Invalid | 当输入的时间段不符合规范时，系统提示并拒绝输入（输出） |
Check.Record | 在库存管理人员结束本次库存查看操作时，系统需记录本次操作的时间以及具体操作记录（逻辑文件） |
Check.Close.Exit | 系统关闭本次库存查看任务 |
Stocking.Excel | 系统可以将库存快照导出Excel并进行保存 |
Stocking.Record | 在库存管理人员结束库存盘点时，系统需记录本次操作的时间以及具体操作记录（逻辑文件） |
Stocking.Close.Exit | 系统关闭本次库存盘点任务 |
Documents.Warn|若总经理审批后或者当某商品数量低于其警戒值的时候，系统会在库存管理人员登录的时候在提示栏里提示总经理审批结果以及警戒信息（输出）|
Documents.Remind|当任一单据确认提交后（查询），系统显示&quot;已提交&quot;（输出） |
Documents.Invalid | 库存管理人员输入不存在的商品或者不符合规范格式的商品数量时，系统提示输入无效 |
Documents.Record | 在库存管理人员结束本次制定单据操作时，系统需记录本次操作的时间以及具体操作记录（逻辑文件） |
Documents.Confirm|在制定单据后会进入草稿状态，库存管理人员点击确认后进入待审批状态（查询）|
Documents.Cancel |任何单据被提交前都可以点击取消结束本次操作（查询）|
Documents.Close.Exit|系统关闭本次制定单据任务 |

进销存系统属于中等系统，所以其功能点测度总数=7\*4 + 21\*5 + 11\*4 + 5\*10 + 0\*7= 194
系统的复杂度因子为40

功能点：

   FP = 194\* (0.65 + 0.01 \* 40) = 203.7

##**进货销售人员度量数据**

用例数量：4

平均每个用例的场景数：11

平均用例行数：200

功能需求数量：44

输入：7

输出：21

查询：11

逻辑文件：5

对外接口：0

| 编号 | 需求描述与度量 |
| --- | --- |
Client.Input|系统允许进货销售人员在客户管理任务(输出: 客户管理主界面)中进行键盘输入和操作|
Client.Input.Find|货销售人员请求输入(查询)，客户编号或姓名(输入)，客户已存在(逻辑文件)|
Client.Cancel|进当进货销售人员发出取消请求时(查询)，系统不做任何逻辑处理，返回上级页面(输出)|
Client.Modify|系统应该允许进货销售人员修改客户信息|
Client.Modify.Start|当进货销售人员发出更改客户信息请求时(查询)，系统显示进货销售人员修改客户信息页面（输出）|
Client.Modify.Select|当进货销售人员选择了某个客户、并确认时(查询)，系统显示该客户的信息(逻辑文件),进入编辑状态 (输出)|
Client.Modify.Filter|系统应该允许进货销售人员在选择客户时使用某一信息进行过滤，参见Client.Filter|
Client.Modify.Null|当进货销售人员不改变任何项的信息时，系统不做任何逻辑处理|
CLient.Modify.End |当进货销售人员修改完毕并确认后(查询)，系统更新数据，提示修改成功(输出) |
| Client.Invalid | 当输入的信息不合法时，系统提示错误，要求重新输入或取消修改(输出) |
Client.Filter| 系统应该可以用某个属性过滤客户|
Client.Filter.ByID|系统应该可以用客户身份证号过滤客户|
Client.Filter.ByName |系统应该可以用客户姓名过滤客户 |
| Client.Close.Exit | 系统关闭本次商品分类管理任务 |
Purchase.Input|系统允许进货人员在制定进货单任务(输出: 制定销售单主界面)中进行键盘和鼠标输入和操作|
Purchase.Cancel|当进货销售人员发出取消请求时(查询)，系统不做任何逻辑处理，返回上级页面(输出)|
Purchase.Select|当进货人员选择了某个商品、并确认时(查询)，系统显示该商品的信息(逻辑文件),进入编辑状态（输入数量、单价等）(输出)|
Purchase.Select.Input|系统应该允许进货人员任意输入商品的数量和单价(输入)|
Purchase.Select.Invalid|当输入的信息不合法时，系统提示错误，要求重新输入或取消修改(输出)| Purchase.Select.Null|当进货人员不改变任何项的信息时，系统不做任何逻辑处理|
Purchase.Blank|当进货人员提交的进货单有空缺项时，系统提示有空缺，并要求补全(输出)|
Purchase.End|当进货销售人员修改完毕并确认后，系统更新数据，提示修改成功(输出)|
Purchase.ExamineAndApprove |当进货单完成后，系统提交至总经理的账号进行审批 |
| Purchase. Close.Exit | 系统关闭本次制定进货单任务 |
PurchaseReturn.Input|系统允许进货人员在制定进货退货单任务(输出: 制定销售单主界面)中进行键盘和鼠标输入和操作|
PurchaseReturn.Cancel|当进货销售人员发出取消请求时(查询)，系统不做任何逻辑处理，返回上级页面(输出)|
PurchaseReturn.Select|当进货人员选择了某个商品、并确认时(查询)，系统显示该商品的信息(逻辑文件),进入编辑状态（输入数量、单价等）(输出)|
PurchaseReturn.Select.Input|系统应该允许进货人员任意输入商品的数量和单价(输入)|
PurchaseReturn.Select.Invalid|当输入的信息不合法时，系统提示错误，要求重新输入或取消修改(输出)|
PurchaseReturn.Select.Null|当进货人员不改变任何项的信息时，系统不做任何逻辑处理|
PurchaseReturn.Blank|当进货人员提交的进货退货单有空缺项时，系统提示有空缺，并要求补全(输出)|
PurchaseReturn.End|当进货销售人员修改完毕并确认后，系统更新数据，提示修改成功(输出)| Purchase.ExamineAndApprove |当进货退货单完成后，系统提交至总经理的账号进行审批 |
| PurchaseReturn.Close.Exit | 系统关闭本次制定进货退货单任务 |
Sale.Input|系统允许销售人员在制定销售单任务(输出: 制定销售单主界面)中进行键盘和鼠标输入和操作|
Sale.Cancel|当进货销售人员发出取消请求时(查询)，系统不做任何逻辑处理，返回上级页面(输出)|
Sale.Select|当销售人员选择了某个商品、并确认时(查询)，系统显示该商品的信息(逻辑文件),进入编辑状态（输入数量、单价等）(输出)|
Sale.Select.Input|系统应该允许销售人员任意输入商品的数量和单价(输入)|
Sale.Select.Invalid|当输入的信息不合法时，系统提示错误，要求重新输入或取消修改(输出)|
Sale.Select.Null|当销售人员不改变任何项的信息时，系统不做任何逻辑处理|
Sale.Blank|当进货人员提交的销售单有空缺项时，系统提示有空缺，并要求补全(输出)|
Sale.End|当进货销售人员修改完毕并确认后，系统更新数据，提示修改成功(输出)|
Sale.ExamineAndApprove |当销售单完成后，系统提交至总经理的账号进行审批 |
| Sale.Close.Exit | 系统关闭本次制定销售单任务

进销存系统属于中等系统，所以其功能点测度总数=7\*4 + 21\*5 + 11\*4 + 5\*10 + 0\*7= 227

系统的复杂度因子为40

功能点：

   FP = 227\* (0.65 + 0.01 \* 40) = 238.35
