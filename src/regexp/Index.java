package regexp;

/* *
 * Java ��������ƥ�䣺
 * 1����� Pattern ���������� Javascript �� RegExp
 * 2��ʹ�� Pattern �������ƥ���� Matcher�������� Javascript ���� match �������õĶ���
 * 3���� Matcher ���в���
 * 	find([index]) ������λ�ÿ�ʼ���ң������ִ�� find ���൱�ڻ�û��ʼƥ�䣨��ͬ�� javascript�������� boolean ��ʾ�Ƿ�ƥ��ɹ�
 *  group([0]) �������ƥ����
 *  group(index) index >= 1����õ� index �����飨��������ʽ���С���ţ���ƥ����
 *  groupCount() ��÷���������������ʽ��С����ƥ�䵽�ķ��飩��ע�⣺ȡ�������ʱ���� group(1 �� groupCount() + 1)
 *  
 * Pattern p = Pattern.compile("\d+");
 * Matcher m = p.matcher("123");
 * System.out.println(m.find());
 * System.out.println(m.group());
 * */

/* *
 * 1��ת��
 * Java �е� \ ��Ҫ��ת��
 * ����Ԫ�ַ���Ҫд�� \\d
 * 
 * 2��������
 * [] �ڲ���Ҫ���� \\ ת�壬��[.]
 * ����Ҫ���� - ��ʾ��Χѡ�񣬲�Ҫ�� [./-] д���� [.-/]
 * */
public class Index {

}
