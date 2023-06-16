import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score

data = {'horse power': [130, 250, 190, 300, 210, 220, 170], 'efficiency': [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2]}
pd_data = pd.DataFrame(data, index=['A', 'B', 'C', 'D', 'E', 'F', 'G'])

# index에 이름 설정
pd_data.index.name = 'name'

print(pd_data)

x = pd_data[['horse power']]
y = pd_data['efficiency']

reg = LinearRegression()
reg.fit(x, y)

# 계수(coefficient) 출력
coefficient = reg.coef_
print('계수:', coefficient)

# 절편(intercept) 출력
intercept = reg.intercept_
print('절편:', intercept)

# explained_variance_score 함수는 회귀 모델의 예측 값이 목표 변수의 분산을 얼마나 잘 설명하는지
# 평가하기 위한 지표로 이 값은 0부터 1까지의 범위를 가지며, 1에 가까울수록 예측이 좋다는 것을 나타낸다.
# R-squared (R^2)는 회귀 모델의 적합도를 나타내는 일반적인 평가 지표로 회귀 모델이
# 얼마나 잘 종속 변수의 변동을 설명하는지를 나타내며, 0부터 1까지의 범위를 가진다.
# r2_score 함수는 scikit-learn에서 제공하는 R-squared 값을 계산하는 함수로
# R-squared는 많은 회귀 문제에서 선호되는 평가 지표 중 하나이며, 회귀 모델의 예측 성능을 종합적으로
# 평가하는 데에 많이 사용된다.

# 학습 데이터에 대한 예측 점수(R-squared score) 출력
prediction = reg.predict(x)
score = r2_score(y, prediction)
print('예측 점수:', score)

horse_power = 280
pred_data = pd.DataFrame({'horse power': [horse_power]})
prediction = reg.predict(pred_data)
print(f'280 마력 자동차의 예상 연비: {prediction[0]:.2f} km/l')
