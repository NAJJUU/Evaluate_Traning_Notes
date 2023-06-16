import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score
import matplotlib.pyplot as plt
import seaborn as sns

data = {'horse power' : [130, 250, 190, 300, 210, 220, 170]
    ,'weight' : [1900, 2600, 2200, 2900, 2400, 2300, 2100]
    , 'efficiency' : [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2]}
pd_data = pd.DataFrame(data, index=['A', 'B', 'C', 'D', 'E', 'F', 'G'])

# index에 이름 설정
pd_data.index.name = 'name'

print(pd_data)

x = pd_data[['horse power', 'weight']]
y = pd_data['efficiency']

reg = LinearRegression()
reg.fit(x, y)

# 계수(coefficient) 출력
coefficient = reg.coef_
print('계수:', coefficient)

# 절편(intercept) 출력
intercept = reg.intercept_
print('절편:', intercept)

# 학습 데이터에 대한 예측 점수(R-squared score) 출력
prediction = reg.predict(x)
score = r2_score(y, prediction)
print('예측 점수:', score)

horse_power = 280
weight = 2500
pred_data = pd.DataFrame({'horse power': [horse_power], 'weight': [weight]})
prediction = reg.predict(pred_data)
print(f'280 마력 자동차의 예상 연비: {prediction[0]:.1f} km/l')


plt.figure()
sns.pairplot(pd_data[['horse power', 'weight', 'efficiency']])
plt.show()

plt.figure()
sns.heatmap(data=pd_data.corr(), square=True, annot=True, fmt=".2f")
plt.show()