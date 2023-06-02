import pandas as pd
import matplotlib.pyplot as plt

sales_data = pd.read_csv('/Users/ezen/Desktop/sales_data_.csv')
month = sales_data['month']
tv = sales_data['tv']
laptop = sales_data['laptop']
phone = sales_data['phone']

plt.plot(month, tv, label='TV', markersize='10', marker='.')  # TV 그래프
plt.plot(month, laptop, label='Laptop', markersize='10', marker='.')  # 노트북 그래프
plt.plot(month, phone, label='Phone', markersize='10', marker='.')  # 휴대폰 그래프

plt.xlabel('month')
plt.ylabel('unit')
plt.title('Na Ju Hwa Sales Data')
plt.grid(True)  # 눈금 표시
plt.legend()  # 범례 표시
plt.show()  # 그래프 표시