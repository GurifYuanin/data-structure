package regexp;

/* *
 * Java 进行正则匹配：
 * 1、获得 Pattern 对象，类似于 Javascript 的 RegExp
 * 2、使用 Pattern 对象进行匹配获得 Matcher，类似于 Javascript 进行 match 方法后获得的对象
 * 3、对 Matcher 进行操作
 * 	find([index]) 从索引位置开始查找，如果不执行 find 就相当于还没开始匹配（不同于 javascript），返回 boolean 表示是否匹配成功
 *  group([0]) 获得所有匹配结果
 *  group(index) index >= 1，获得第 index 个分组（即正则表达式里的小括号）的匹配结果
 *  groupCount() 获得分组数（即正则表达式里小括号匹配到的分组）！注意：取出分组的时候是 group(1 到 groupCount() + 1)
 *  
 * Pattern p = Pattern.compile("\d+");
 * Matcher m = p.matcher("123");
 * System.out.println(m.find());
 * System.out.println(m.group());
 * */

/* *
 * 1、转义
 * Java 中的 \ 需要被转义
 * 所以元字符需要写成 \\d
 * 
 * 2、方括号
 * [] 内不需要进行 \\ 转义，如[.]
 * 但需要留意 - 表示范围选择，不要把 [./-] 写成了 [.-/]
 * */
public class Index {

}
